package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;

public interface IDetalleSolicitudService {
	
	public detalle_solicitud save (detalle_solicitud ds);
	public List<detalle_solicitud> detalles_de_solicitud (long id);
	
}
