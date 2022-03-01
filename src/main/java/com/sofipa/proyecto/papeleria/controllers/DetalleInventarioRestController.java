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
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;
import com.sofipa.proyecto.papeleria.models.services.IDetalleInventarioService;
import com.sofipa.proyecto.papeleria.models.entity.InventarioDetallePK;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DetalleInventarioRestController {
	@Autowired
	private IDetalleInventarioService detalleInventarioService;
	
	@PostMapping("/detalle_inventario")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_inventario create (@RequestBody detalle_inventario di)
	{
		InventarioDetallePK inventarioDetpk = new InventarioDetallePK();
		inventarioDetpk.setIdProducto(di.getInventario().getId_inventario());
		inventarioDetpk.setIdInventario(di.getProducto().getId_producto());
		di.setInventarioDetallePK(inventarioDetpk);
		return detalleInventarioService.save(di);
	}
	
	@PutMapping("/detalle_inventario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_inventario> update(@RequestBody detalle_inventario [] detalles_i, @PathVariable Long id)
	{
		detalle_inventario detaActual = new detalle_inventario();
		for(int i=0; i< detalles_i.length; i++)
		{
			detaActual = detalles_i[i];
			detalleInventarioService.save(detaActual);
		}
		
		return detalleInventarioService.detalles_de_inventario(id);
	}
	
	@GetMapping("/detalle_inventario/{id}")
	public List<detalle_inventario> detalles_de_inv(@PathVariable Long id)
	{
		return detalleInventarioService.detalles_de_inventario(id);
	}
}
