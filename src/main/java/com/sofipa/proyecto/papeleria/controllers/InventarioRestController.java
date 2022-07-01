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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.proyecto.papeleria.models.entity.Inventario;
import com.sofipa.proyecto.papeleria.models.services.IInventarioService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class InventarioRestController {
	@Autowired 
	private IInventarioService inventarioService;
	
	//Metodo  para obtener todos los inventarios
	@GetMapping("/inventario")
	public List<Inventario> index ()
	{
		return inventarioService.findAll();
	}
	
	//Metodo para obtener un inventario mediante su id
	@GetMapping("/inventario/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Inventario inventario = null;
		Map<String, Object> response = new HashMap<>();
		try {
			inventario = inventarioService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (inventario == null) {
			response.put("mensaje", "¡el ID:" + id + " no existe!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			// Si el inventario por su ID se encontro manda mismo y un mensaje de
			// exito
			response.put("mensaje", "encontrado con exito");
			response.put("inventario", inventario);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
	}
	
	//Metodo para obtener un Inventario mediante la sucursal al que pertenece
	@GetMapping("/inventario/Sucursal/{id}")
	public Inventario showIS (@PathVariable Long id) 
	{
		return inventarioService.findByIdSucursal(id);
	}
	
	//Metodo para crear un nuevo Inventario
	@PostMapping("/inventario")
	@ResponseStatus(HttpStatus.CREATED)
	public Inventario create (@RequestBody Inventario inventario)
	{
		return inventarioService.save(inventario);
	}
	
	//Metodo para actualizar un inventario
	@PutMapping("/inventario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Inventario update (@RequestBody Inventario inventario, @PathVariable Long id)
	{
		Inventario inventarioActual = inventarioService.findById(id);
		inventarioActual.setFecha_ultima_actualizacion(inventario.getFecha_ultima_actualizacion());
		inventarioActual.setIdSucursal(inventario.getIdSucursal());
		inventarioActual.setNombre_sucursal(inventario.getNombre_sucursal());
		
		return inventarioService.save(inventarioActual);
	}
}
