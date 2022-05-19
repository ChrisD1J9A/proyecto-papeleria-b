package com.sofipa.proyecto.papeleria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;	
import com.sofipa.proyecto.papeleria.models.entity.Producto;
import com.sofipa.proyecto.papeleria.models.services.IProductoService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	@Autowired
	private IProductoService productoService;
	
	//Metodo que devuelve todos los productos de la base de datos
	@GetMapping("/productos")
	public List<Producto> index()
	{
		return productoService.findAll();
	}
	
	//Metodo que devuelve un producto mediante su identificador(id_producto)
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id)
	{
		//Se declara el Objeto Producto que almacenará la consulta
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
		try {
			//Se realiza la consulta
			producto = productoService.findById(id);
			//En caso de haber errores, son manejados en el catch
		}catch(DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//Se válida que el producto buscado  exista, de no existir se notifica 
		if(producto == null) {
			response.put("mensaje", "El producto con el ID: ".concat(id.toString().concat(". No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		//En caso de no haber erroes se manda el Producto 	
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		
	}
	
	//Método para crear un nuevo Producto
	@PostMapping("/productos")
	public ResponseEntity<?> create (@RequestBody Producto producto)
	{
		//Se declara un objeto de tipo Producto para mandar como respuesta
		Producto productoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			//Se realiza la inserción en la base de datos 
			productoNew = productoService.save(producto);
		}catch (DataAccessException e){
			//En caso de haber errores se manejan en esta área
			response.put("mensaje", "error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//De no haber errores se manda el producto creado a lado de un mensaje de inserción exitosa
		response.put("mensaje","El producto ha sido creado con éxito");
		response.put("producto", productoNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//Método para actualizar Productos de la base de datos
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id)
	{
		/*Se declaran dos objetos, uno para guardar el producto a actualizar y consultar en la base de datos
		 *mediante el id y el otro para guardar el producto una vez actualizado en la base de datos*/ 
		Producto productoActual = productoService.findById(id);
		Producto productoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		//Se corrobora que el producto a actualizar exista en la base de datos, en caso de no existir se notifica
		if (productoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el producot con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			//Se efectúan los cambios en la base de datos
			productoActual.setDescripcion(producto.getDescripcion());
			productoActual.setPrecio_iva(producto.getPrecio_iva());
			productoActual.setPrecio_subtotal(producto.getPrecio_subtotal());
			productoActual.setPrecio_total(producto.getPrecio_total());
			productoActual.setEstatus(producto.getEstatus());
			productoActual.setObservaciones(producto.getObservaciones());
			productoActual.setUnidad(producto.getUnidad());
			productoUpdated = productoService.save(productoActual);
			//Cualquier error se maneja en el catch
		}catch(DataAccessException e){
			response.put("mensaje", "error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//De no haber errrores se notifica al usuario y se manda el producto actualizado 
		response.put("mensaje","El producto ha sido actualizado con éxito");
		response.put("producto", productoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
