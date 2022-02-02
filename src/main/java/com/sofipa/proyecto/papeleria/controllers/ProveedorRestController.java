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
	public Proveedor show (@PathVariable Long id)
	{
		return proveedorService.findById(id);
	}
	
	@PostMapping("/proveedores")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor create(@RequestBody Proveedor proveedor)
	{
		return proveedorService.save(proveedor);
	}
	
	@PutMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor update(@RequestBody Proveedor proveedor, @PathVariable Long id)
	{
		Proveedor proveedorActual = proveedorService.findById(id);
		
		proveedorActual.setNombre(proveedor.getNombre());
		proveedorActual.setDireccion(proveedor.getDireccion());
		proveedorActual.setTelefono(proveedor.getTelefono());
		proveedorActual.setRfc(proveedor.getRfc());
		proveedorActual.setEstatus(proveedor.getEstatus());
		
		return proveedorService.save(proveedorActual);
	}
	
}
