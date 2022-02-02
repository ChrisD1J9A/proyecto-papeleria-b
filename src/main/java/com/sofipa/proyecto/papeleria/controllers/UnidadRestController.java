package com.sofipa.proyecto.papeleria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public Unidad show(@PathVariable Long id)
	{
		return unidadService.findById(id);
	}
	
	@PostMapping("/unidades")
	@ResponseStatus(HttpStatus.CREATED)
	public Unidad create (@RequestBody Unidad unidad)
	{
		return unidadService.save(unidad);
	}
	
	@PutMapping("/unidades/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Unidad update(@RequestBody Unidad unidad, @PathVariable Long id)
	{
		Unidad unidadActual = unidadService.findById(id);
		
		unidadActual.setDescripcion(unidad.getDescripcion());
		unidadActual.setEstatus(unidad.getEstatus());
		
		return unidadService.save(unidadActual);
	}
	
	@PutMapping("/unidadB/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Unidad baja(@RequestBody Unidad unidad, @PathVariable Long id)
	{
		Unidad unidadActual = unidadService.findById(id);
		unidadActual.setEstatus(0);
		return unidadService.save(unidadActual);
	}
	/*@DeleteMapping("/unidad/{id}")
	 * @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id)
	{
		unidadService.delete(id);
	}*/
}
