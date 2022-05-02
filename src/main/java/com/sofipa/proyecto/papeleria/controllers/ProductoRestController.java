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
	
	@GetMapping("/productos")
	public List<Producto> index()
	{
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id)
	{
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
		try {
			producto = productoService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(producto == null) {
			response.put("mensaje", "El producto con el ID: ".concat(id.toString().concat(". No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> create (@RequestBody Producto producto)
	{
		Producto productoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productoNew = productoService.save(producto);
		}catch (DataAccessException e){
			response.put("mensaje", "error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido creado con éxito");
		response.put("producto", productoNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id)
	{
		Producto productoActual = productoService.findById(id);
		Producto productoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (productoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el producot con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			productoActual.setDescripcion(producto.getDescripcion());
			productoActual.setPrecio_iva(producto.getPrecio_iva());
			productoActual.setPrecio_subtotal(producto.getPrecio_subtotal());
			productoActual.setPrecio_total(producto.getPrecio_total());
			productoActual.setEstatus(producto.getEstatus());
			productoActual.setObservaciones(producto.getObservaciones());
			productoActual.setUnidad(producto.getUnidad());
			productoUpdated = productoService.save(productoActual);
			
		}catch(DataAccessException e){
			response.put("mensaje", "error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido actualizado con éxito");
		response.put("producto", productoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
