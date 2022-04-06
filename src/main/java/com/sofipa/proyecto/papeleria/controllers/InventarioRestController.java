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

import com.sofipa.proyecto.papeleria.models.entity.Inventario;
import com.sofipa.proyecto.papeleria.models.services.IInventarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class InventarioRestController {
	@Autowired 
	private IInventarioService inventarioService;
	
	@GetMapping("/inventario")
	public List<Inventario> index ()
	{
		return inventarioService.findAll();
	}
	
	@GetMapping("/inventario/{id}")
	public Inventario show (@PathVariable Long id) 
	{
		return inventarioService.findById(id);
	}
	
	@GetMapping("/inventario/Sucursal/{id}")
	public Inventario showIS (@PathVariable Long id) 
	{
		return inventarioService.findBySucursal(id);
	}
	
	@PostMapping("/inventario")
	@ResponseStatus(HttpStatus.CREATED)
	public Inventario create (@RequestBody Inventario inventario)
	{
		return inventarioService.save(inventario);
	}
	
	
	@PutMapping("/inventario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Inventario update (@RequestBody Inventario inventario, @PathVariable Long id)
	{
		Inventario inventarioActual = inventarioService.findById(id);
		inventarioActual.setFecha_ultima_actualizacion(inventario.getFecha_ultima_actualizacion());
		inventarioActual.setId_sucursal(inventario.getId_sucursal());
		inventarioActual.setNombre_sucursal(inventario.getNombre_sucursal());
		
		return inventarioService.save(inventarioActual);
	}
}
