package com.sofipa.proyecto.papeleria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.sofipa.proyecto.papeleria.models.entity.Compra;
import com.sofipa.proyecto.papeleria.models.services.ICompraService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CompraRestController {
	@Autowired 
	private ICompraService compraService;
	
	//Método que devuelve todas las compras de la base de datos
	@GetMapping("/compras")
	public List<Compra> index()
	{
		return compraService.findAll();
	}
	
	//Método que devuelve una compra mediante su identificador(id_compra)
	@GetMapping("/compras/{id}")
	public Compra show(@PathVariable Long id) 
	{
		return compraService.findById(id);
	}
	
	//Método que devuelve todas las compras de una determinada sucursal
	@GetMapping("/compras/sucursal/{id}")
	public List <Compra> showCS(@PathVariable Long id) 
	{
		return compraService.findBySucursal(id);
	}
	
	//Método para crear una nueva Compra
	@PostMapping("/compras")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra create(@RequestBody Compra compra)
	{
		return compraService.save(compra);
	}
	
	//Método para actualizar una nueva solicitud
	@PutMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra update(@RequestBody Compra compra, @PathVariable Long id)
	{
		//Se busca la compra a actualizar en la base de datos
		Compra compraActual = compraService.findById(id);
		//Se realizan los posibles cambios
		compraActual.setSolicitud(compra.getSolicitud());
		compraActual.setProveedor(compra.getProveedor());
		compraActual.setId_sucursal(compra.getId_sucursal());
		compraActual.setNombre_sucursal(compra.getNombre_sucursal());
		compraActual.setUsuario(compra.getUsuario());
		compraActual.setFecha_creacion(compra.getFecha_creacion());
		compraActual.setGasto_total(compra.getGasto_total());
		compraActual.setTicket(compra.getTicket());
		compraActual.setObservaciones(compra.getObservaciones());
		compraActual.setEstatus(compra.getEstatus());
		//Y se actualiza la compra
		return compraService.save(compraActual);
	}
	
	//Método para subir un archivo 
	@PostMapping("/compras/add/file")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		//Se busca la compra a la que se asocia el ticket(Archivo)
		Compra compra = compraService.findById(id);
		//Se valida si el archivo existe
		if(!archivo.isEmpty())
		{
			//Se obtiene el nombre del archivo y se añaden caracteres randoms para evitar que se repitan 
			//los nombres de los archivos en su destino
			String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			//Se define la ruta dónde se almacenaran los archivos
			Path rutaArchivo = Paths.get("uploads/tickets").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo); //mover, copiar el achivo subida a la ruta definida
			} catch (IOException e) {
				//Área para manejar los errores
				response.put("mensaje", "Error al subir el ticket" + nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String archivoAnterior = compra.getTicket();
			if(archivoAnterior !=null && archivoAnterior.length() >0) {
				Path rutaArchivoAnterior = Paths.get("uploads/tickets").resolve(archivoAnterior).toAbsolutePath();
				File archivoResAnterior = rutaArchivoAnterior.toFile();
				if(archivoResAnterior.exists() && archivoResAnterior.canRead()) {
					archivoResAnterior.delete();
				}
			}
			//En la base de datos, sólo se guarda el nombre del archivo
			compra.setTicket(nombreArchivo);
			//Se actualiza la compra
			compraService.save(compra);
			//Se manda la compra en conjunto con el nombre del archivo subido 
			response.put("compra", compra);
			response.put("mensaje", "Ha subido correctamente el ticket: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
	}
	
	//Método para Obtener un Archivo para Verlo ó Descargar
	@GetMapping("/compras/show/archivo/{nombreArchivo:.+}")
	public ResponseEntity<Resource> verArchivo(@PathVariable String nombreArchivo){
		Path rutaArchivo = Paths.get("uploads/tickets").resolve(nombreArchivo).toAbsolutePath();
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar el archivo: " + nombreArchivo);
		}
		HttpHeaders cabecera = new HttpHeaders();
		//para forzar la descarga
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\""); 
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	//Metodo para obtener las compras con mayores gastos en las sucursales en los ultimos meses(Parámetro requerido)
	@GetMapping("/compras/reportes/maxGasto/{meses}")
	public List<Object> maximoGastoDeComprasPorSucursal(@PathVariable int meses)
	{
		return compraService.maximoGastoDeComprasPorSucursal(meses);
	}
	
	//Metodo para obtener las compras con mayores gastos en las sucursales desde siempre(Histórico)
	@GetMapping("/compras/reportes/maxGasto")
	public List<Object> maximoGastoDeComprasPorSucursalHistorico()
	{
		return compraService.maximoGastoDeComprasPorSucursalHistorico();
	}
	
	//Metodo para obtener las compras con mayores gastos en las sucursales en un rango de fechas
	@GetMapping("/compras/reportes/maxGasto/{fecha1}/{fecha2}")
	public List<Object> maximoGastoDeComprasPorSucursalRangos(@PathVariable String fecha1, @PathVariable String fecha2)
	{
		return compraService.maximoGastoDeComprasPorSucursalRangoFechas(fecha1, fecha2);
	}
	
	//Metodo para obtener obtener el gasto total efectuado en las compras de cada sucursal en los ultimos meses(Parámetro requierido) 
	@GetMapping("/compras/reportes/gastoTotal/{meses}")
	public List<Object> gastoTotalDeComprasPorSucursal(@PathVariable int meses)
	{
		return compraService.gastoTotalDeComprasPorSucursal(meses);
	}
	
	//Metodo para obtener obtener el gasto total efectuado en las compras de cada sucursal Históricamente
	@GetMapping("/compras/reportes/gastoTotal")
	public List<Object> gastoTotalDeComprasPorSucursalHistorico()
	{
		return compraService.gastoTotalDeComprasPorSucursalHistorico();
	}
	
	//Metodo para obtener obtener el gasto total efectuado en las compras de cada sucursal en un determinado rango de fechas
	@GetMapping("/compras/reportes/gastoTotal/{fecha1}/{fecha2}")
	public List<Object> gastoTotalDeComprasPorSucursalRangos(@PathVariable String fecha1, @PathVariable String fecha2)
	{
		return compraService.gastoTotalDeComprasPorSucursalRangoFechas(fecha1, fecha2);
	}
	
	//Metodo para obtener las compras en un intervalo de tiempo (Por ejemplo los últimos 12 meses)
	@GetMapping("/compras/tiempo/{meses}")
	public List<Compra> comprasPorTiempo (@PathVariable int meses)
	{
		return compraService.comprasPorTiempo(meses);
	}
	
	//Metodo para obtener las compras en un rango de fechas 
	@GetMapping("/compras/tiempo/{fecha1}/{fecha2}")
	public List<Compra> comprasPorRangoFechas (@PathVariable String fecha1, @PathVariable String fecha2)
	{
		return compraService.comprasPorRangoFechas(fecha1, fecha2);
	}
	
}
