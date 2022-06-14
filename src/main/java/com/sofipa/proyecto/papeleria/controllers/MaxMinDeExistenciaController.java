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
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeExistencia;
import com.sofipa.proyecto.papeleria.models.services.IMaxMinDeExistenciaService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MaxMinDeExistenciaController 
{
	@Autowired 
	private IMaxMinDeExistenciaService maxMinExistenciaService;
	
	//Método para obtener todas las configuraciones 
	@GetMapping("/maxMinExistencia")
	public List<MaxMinDeExistencia> index()
	{
		return maxMinExistenciaService.findAll();
	}
	
	//Método para obtener una configuración mediante su id
	@GetMapping("/maxMinExistencia/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		MaxMinDeExistencia maxMinDeExistencia = null;
		Map<String, Object> response = new HashMap<>();
		try {
			maxMinDeExistencia = maxMinExistenciaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (maxMinDeExistencia == null) {
			response.put("mensaje", "¡el ID:" + id + " no existe!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			// Si la configuracion por su ID se encontro manda la config y un mensaje de
			// exito
			response.put("mensaje", "encontrado con exito");
			response.put("maxMinDeExistencia", maxMinDeExistencia);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
	}
	
	//Método para obtener la configuración de una determinada sucursal
	@GetMapping("/maxMinExistenciaS/{sucursal}")
	public MaxMinDeExistencia showBySucursal (@PathVariable String sucursal) 
	{
		return maxMinExistenciaService.findBySucursal(sucursal);
	}
	
	//Método para crear una nueva configuración
	@PostMapping("/maxMinExistencia")
	@ResponseStatus(HttpStatus.CREATED)
	public MaxMinDeExistencia create(@RequestBody MaxMinDeExistencia maxMinDeExistencia)
	{
		return maxMinExistenciaService.save(maxMinDeExistencia);
	}
	
	//Método para  actualizar una nueva configuración
	@PutMapping("/maxMinExistencia/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public MaxMinDeExistencia update(@RequestBody MaxMinDeExistencia maxMinDeExistencia, @PathVariable Long id)
	{ 
		MaxMinDeExistencia maxMinExistenciaActual = maxMinExistenciaService.findById(id);
		maxMinExistenciaActual.setSucursal(maxMinDeExistencia.getSucursal());
		maxMinExistenciaActual.setMax_existencia(maxMinDeExistencia.getMax_existencia());
		maxMinExistenciaActual.setMin_existencia(maxMinDeExistencia.getMin_existencia());
		maxMinExistenciaActual.setUsuario_modifico(maxMinDeExistencia.getUsuario_modifico());
		maxMinExistenciaActual.setEstatus(maxMinDeExistencia.getEstatus());
		maxMinExistenciaActual.setFecha_creacion(maxMinDeExistencia.getFecha_creacion());
		maxMinExistenciaActual.setFecha_actualizacion(maxMinDeExistencia.getFecha_actualizacion());
		
		return maxMinExistenciaService.save(maxMinExistenciaActual);
	}
}
