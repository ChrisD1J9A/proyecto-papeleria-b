package com.sofipa.proyecto.papeleria.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.proyecto.papeleria.models.entity.CompraDetallePK;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;
import com.sofipa.proyecto.papeleria.models.services.IDetalleCompraService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DetalleCompraRestController {
	@Autowired
	private IDetalleCompraService detalleCompraService;
	
	@PostMapping("/detalle_compra")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_compra create (@RequestBody detalle_compra dc)
	{
		CompraDetallePK compraDetallePk = new CompraDetallePK();
		compraDetallePk.setIdCompra(dc.getCompra().getId_compra());
		compraDetallePk.setIdProducto(dc.getProducto().getId_producto());
		dc.setCompraDetallePK(compraDetallePk);
		return detalleCompraService.save(dc);
	}
	
	@PutMapping("/detalle_compra/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_compra> update(@RequestBody detalle_compra[] detalles_f, @PathVariable Long id)
	{
		detalle_compra detaActual = new detalle_compra();
		for(int i =  0; i < detalles_f.length; i++)
		{
			detaActual = detalles_f[i];
			detalleCompraService.save(detaActual);
		}
		
		return detalleCompraService.soloDetallesCompra(id);
		
	}
}
