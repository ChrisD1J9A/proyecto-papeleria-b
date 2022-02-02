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
	public Producto show(@PathVariable Long id)
	{
		return productoService.findById(id);
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create (@RequestBody Producto producto)
	{
		return productoService.save(producto);
	}
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id)
	{
		Producto productoActual = productoService.findById(id);
		
		productoActual.setDescripcion(producto.getDescripcion());
		productoActual.setPrecio_iva(producto.getPrecio_iva());
		productoActual.setPrecio_subtotal(producto.getPrecio_subtotal());
		productoActual.setPrecio_total(producto.getPrecio_total());
		productoActual.setEstatus(producto.getEstatus());
		productoActual.setObservaciones(producto.getObservaciones());
		productoActual.setUnidad(producto.getUnidad());
		
		return productoService.save(productoActual);
	}
	
	@PutMapping("/productoB/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto baja(@RequestBody Producto producto, @PathVariable Long id)
	{
		Producto productoActual = productoService.findById(id);
		productoActual.setEstatus(0);
		return productoService.save(productoActual);
	}
}
