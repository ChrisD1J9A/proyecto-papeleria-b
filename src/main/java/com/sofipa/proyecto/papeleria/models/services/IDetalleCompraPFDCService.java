package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_PFDC;

public interface IDetalleCompraPFDCService {
	
	/*Servicio para guardar, crear, actualizar un detalle compra con productos fuera del catalogo 
	 *en la base de datos*/
	public detalle_compra_PFDC save (detalle_compra_PFDC ds);
	
	/*Servicio para obtener los detalles de compra con productos fuera del catalogo de una Compra 
	 *(mediante id_compra)*/
	public List<detalle_compra_PFDC> detalles_de_compra_PFDC (long id);
}
