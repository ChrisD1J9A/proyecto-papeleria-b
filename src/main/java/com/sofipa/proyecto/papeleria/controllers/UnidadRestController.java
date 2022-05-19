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

import com.sofipa.proyecto.papeleria.models.entity.Unidad;
import com.sofipa.proyecto.papeleria.models.services.IUnidadService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UnidadRestController {
	@Autowired
	
	private IUnidadService unidadService;
	
	@GetMapping("/unidades")
	public List<Unidad> index()
	{
		return unidadService.findAll();
	}
	
	@GetMapping("/unidades/{id}")
	public ResponseEntity<?> show (@PathVariable Long id)
	{
		Unidad unidad = null;
		Map<String, Object> response = new HashMap<>();
		try {
			unidad = unidadService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(unidad == null) {
			response.put("mensaje", "La unidad con el ID: ".concat(id.toString().concat(". No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Unidad>(unidad, HttpStatus.OK);
	}
	
	@PostMapping("/unidades")
	public ResponseEntity<?> create (@RequestBody Unidad unidad)
	{
		Unidad unidadNueva = null;
		Map<String, Object> response = new HashMap<>();
		try {
			unidadNueva = unidadService.save(unidad);
		}catch (DataAccessException e){
			response.put("mensaje", "error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido creado con éxito");
		response.put("producto", unidadNueva);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/unidades/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Unidad unidad, @PathVariable Long id)
	{
		Unidad unidadActual = unidadService.findById(id);
		Unidad unidadUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(unidadActual == null){
			response.put("mensaje", "Error: no se pudo editar, la unidad con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			unidadActual.setDescripcion(unidad.getDescripcion());
			unidadActual.setEstatus(unidad.getEstatus());
			unidadUpdated = unidadService.save(unidadActual);
		}catch(DataAccessException e){
			response.put("mensaje", "error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La unidad ha sido actualizado con éxito");
		response.put("unidado", unidadUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
