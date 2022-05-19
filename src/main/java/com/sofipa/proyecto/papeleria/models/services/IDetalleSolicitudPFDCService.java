package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud_PFDC;

public interface IDetalleSolicitudPFDCService {
	
	//Servicio para obtener todos los detalle de solicitud con productos fuera del catalogo  de la base de datos
	public List<detalle_solicitud_PFDC> findAll();
	
	/*Servicio para guardar, crear, actualizar un detalle solicitud con productos fuera del catalogo 
	 *en la base de datos
	 **/
	public detalle_solicitud_PFDC save (detalle_solicitud_PFDC ds);
	
	/*Servicio para obtener los detalles de solicitud de una Solicitud con productos fuera del catalogo 
	 *(mediante id_solicitud)*/
	public List<detalle_solicitud_PFDC> detalles_de_solicitud_PFDC (long id);
}
