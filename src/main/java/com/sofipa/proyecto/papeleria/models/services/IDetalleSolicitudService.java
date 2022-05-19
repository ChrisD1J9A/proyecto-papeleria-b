package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;

public interface IDetalleSolicitudService {
	
	//Servicio para guardar, crear, actualizar un detalle solicitud en la base de datos
	public detalle_solicitud save (detalle_solicitud ds);
	
	//Servicio para obtener los detalles de solicitud de una Solicitud (mediante id_solicitud)
	public List<detalle_solicitud> detalles_de_solicitud (long id);
	
}
