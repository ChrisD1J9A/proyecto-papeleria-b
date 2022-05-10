package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IDetalleSolicitudPFDCDao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud_PFDC;

@Service
public class DetalleSolicitudPFDCServiceImpl implements IDetalleSolicitudPFDCService{
	@Autowired
	private IDetalleSolicitudPFDCDao detalleSolicitudDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<detalle_solicitud_PFDC> detalles_de_solicitud_PFDC(long id) {
		return detalleSolicitudDao.detalles_de_solicitud_PFDC(id); 
	}

	@Override
	public detalle_solicitud_PFDC save(detalle_solicitud_PFDC ds) {
		return detalleSolicitudDao.save(ds);
	}

	@Override
	public List<detalle_solicitud_PFDC> findAll() {
		return (List<detalle_solicitud_PFDC>) detalleSolicitudDao.findAll();
	}
}
