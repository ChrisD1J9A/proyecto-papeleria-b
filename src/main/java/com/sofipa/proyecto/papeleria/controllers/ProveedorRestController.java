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
import com.sofipa.proyecto.papeleria.models.entity.Proveedor;
import com.sofipa.proyecto.papeleria.models.services.IProveedorService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/proveedores")
	public List<Proveedor> index()
	{
		return proveedorService.findAll();
	}
	
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<?> show (@PathVariable Long id)
	{
		Proveedor proveedor = null;
		Map<String, Object> response = new HashMap<>();
		try {
			proveedor = proveedorService.findById(id);
		} catch(DataAccessException dae) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", dae.getMessage().concat(" : ").concat(dae.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (proveedor == null) {
			response.put("mensaje", "El proveedor con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
		
	}
	
	@PostMapping("/proveedores")
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor)
	{
		Proveedor proveedorNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			proveedorNew = proveedorService.save(proveedor);
		}catch(DataAccessException e){
			response.put("mensaje", "error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El proveedor ha sido creado con éxito");
		response.put("proveedor", proveedorNew);
		 
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/proveedores/{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedor, @PathVariable Long id)
	{
		Proveedor proveedorActual = proveedorService.findById(id);
		Proveedor proveedorUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if (proveedorActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el proveedor con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		
		try {
			proveedorActual.setNombre(proveedor.getNombre());
			proveedorActual.setDireccion(proveedor.getDireccion());
			proveedorActual.setTelefono(proveedor.getTelefono());
			proveedorActual.setRfc(proveedor.getRfc());
			proveedorActual.setEstatus(proveedor.getEstatus());
			proveedorUpdated =  proveedorService.save(proveedorActual);
			
		}catch(DataAccessException e){
			response.put("mensaje", "error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje","El proveedor ha sido actualizado con éxito");
		response.put("proveedor", proveedorUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
