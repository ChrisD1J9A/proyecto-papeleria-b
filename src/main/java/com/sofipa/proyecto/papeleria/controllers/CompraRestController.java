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
import com.sofipa.proyecto.papeleria.models.entity.Proveedor;
import com.sofipa.proyecto.papeleria.models.services.ICompraService;
import com.sofipa.proyecto.papeleria.models.services.IProveedorService;

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
	
	/*@Autowired 
	private IDetalleCompraService detalleCompraService;*/
	
	@GetMapping("/compras")
	public List<Compra> index()
	{
		return compraService.findAll();
	}
	
	@GetMapping("/compras/{id}")
	public Compra show(@PathVariable Long id) 
	{
		return compraService.findById(id);
	}
	
	@PostMapping("/compras")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra create(@RequestBody Compra compra)
	{
			return compraService.save(compra);
	}
	
	@PutMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra update(@RequestBody Compra compra, @PathVariable Long id)
	{
		Compra compraActual = compraService.findById(id);
		compraActual.setSolicitud(compra.getSolicitud());
		compraActual.setProveedor(compra.getProveedor());
		compraActual.setUsuario(compra.getUsuario());
		compraActual.setFecha_creacion(compra.getFecha_creacion());
		compraActual.setGasto_total(compra.getGasto_total());
		compraActual.setTicket(compra.getTicket());
		compraActual.setObservaciones(compra.getObservaciones());
		compraActual.setEstatus(compra.getEstatus());
		
		return compraService.save(compraActual);
	}
	
	@PostMapping("/compras/add/file")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		Compra compra = compraService.findById(id);
		
		if(!archivo.isEmpty())
		{
			String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("C:/Users/GERENTE REGIONAL/Documents/proyecto-papeleria/tickets").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo); //mover, copiar el achivo subida a la ruta definida
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la responsiva" + nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String archivoAnterior = compra.getTicket();
			if(archivoAnterior !=null && archivoAnterior.length() >0) {
				Path rutaArchivoAnterior = Paths.get("C:/Users/GERENTE REGIONAL/Documents/proyecto-papeleria/tickets").resolve(archivoAnterior).toAbsolutePath();
				File archivoResAnterior = rutaArchivoAnterior.toFile();
				if(archivoResAnterior.exists() && archivoResAnterior.canRead()) {
					archivoResAnterior.delete();
				}
			}
			compra.setTicket(nombreArchivo);
			compraService.save(compra);
			
			response.put("compra", compra);
			response.put("mensaje", "Ha subido correctamente el ticket: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/compras/show/archivo/{nombreArchivo:.+}")
	public ResponseEntity<Resource> verArchivo(@PathVariable String nombreArchivo){
		Path rutaArchivo = Paths.get("C:/Users/GERENTE REGIONAL/Documents/proyecto-papeleria/tickets").resolve(nombreArchivo).toAbsolutePath();
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
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\""); //para forzar la descarga
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
}
