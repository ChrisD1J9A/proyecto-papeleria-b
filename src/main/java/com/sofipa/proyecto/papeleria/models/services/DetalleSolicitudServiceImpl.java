package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IDetalleSolicitudDao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;

@Service
public class DetalleSolicitudServiceImpl implements IDetalleSolicitudService{
	@Autowired
	private IDetalleSolicitudDao detalleSolicitudDao;
	
	//Servicio para guardar, crear, actualizar un detalle solicitud en la base de datos
	@Override
	public detalle_solicitud save(detalle_solicitud ds) {
		return detalleSolicitudDao.save(ds);
	}
	
	//Servicio para obtener los detalles de solicitud de una Solicitud (mediante id_solicitud)
	@Override
	@Transactional(readOnly = true)
	public List<detalle_solicitud> detalles_de_solicitud(long id) {
		return detalleSolicitudDao.detalles_de_solicitud(id); 
	}
}
