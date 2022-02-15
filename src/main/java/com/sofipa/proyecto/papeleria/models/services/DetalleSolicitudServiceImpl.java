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
	
	@Override
	public detalle_solicitud save(detalle_solicitud ds) {
		return detalleSolicitudDao.save(ds);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<detalle_solicitud> detalles_de_solicitud(long id) {
		return detalleSolicitudDao.detalles_de_solicitud(id); 
	}

	@Override
	public List<detalle_solicitud> soloDetallesSolicitud(long id) {
		return detalleSolicitudDao.soloDetallesSolicitud(id);
	}
}
