package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;

public interface IDetalleCompraService {
	public detalle_compra save (detalle_compra dc);
	public List<detalle_compra> detalles_de_compra (long id);
	public List<detalle_compra> soloDetallesCompra (long id);
}
