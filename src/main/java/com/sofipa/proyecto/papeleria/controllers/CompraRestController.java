package com.sofipa.proyecto.papeleria.controllers;

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

import com.sofipa.proyecto.papeleria.models.entity.Compra;
import com.sofipa.proyecto.papeleria.models.services.ICompraService;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CompraRestController {
	@Autowired 
	private ICompraService compraService;
	
	/*@Autowired 
	private IDetalleCompraService detalleCompraService;*/
	
	@GetMapping("/compras")
	public List<Compra> index()
	{
		return compraService.findAll();
	}
	
	@GetMapping("/solicitudes/{id}")
	public Compra show(@PathVariable Long id) 
	{
		return compraService.findById(id);
	}
	
	@PostMapping("/solicitudes")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra create(@RequestBody Compra compra)
	{
		return compraService.save(compra); 	
	}
	
	@PutMapping("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra update(@RequestBody Compra compra, @PathVariable Long id)
	{
		Compra compraActual = compraService.findById(id);
		compraActual.setSolicitud(compra.getSolicitud());
		compraActual.setProveedor(compra.getProveedor());
		compraActual.setUsuario(compra.getUsuario());
		compraActual.setFecha_creacion(compra.getFecha_creacion());
		compraActual.setGasto_total(compra.getGasto_total());
		compraActual.setTicket(compra.getTicket());
		compraActual.setObservaciones(compra.getObservaciones());
		
		return compraService.save(compraActual);
	}
	

}
