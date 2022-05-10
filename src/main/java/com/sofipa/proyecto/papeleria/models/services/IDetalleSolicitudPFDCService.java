package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud_PFDC;

public interface IDetalleSolicitudPFDCService {
	
	public List<detalle_solicitud_PFDC> findAll();
	
	public detalle_solicitud_PFDC save (detalle_solicitud_PFDC ds);
	
	public List<detalle_solicitud_PFDC> detalles_de_solicitud_PFDC (long id);
}
