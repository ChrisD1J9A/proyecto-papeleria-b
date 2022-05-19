package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;

public interface IDetalleCompraService {
	
	//Servicio para guardar, crear, actualizar un detalle compra en la base de datos
	public detalle_compra save (detalle_compra dc);
	
	//Servicio para obtener los detalles de compra de una Compra (mediante id_compra)
	public List<detalle_compra> detalles_de_compra (long id);
}
