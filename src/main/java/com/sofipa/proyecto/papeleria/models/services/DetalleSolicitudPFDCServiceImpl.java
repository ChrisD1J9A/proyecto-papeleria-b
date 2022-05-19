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
	
	//Servicio para obtener todos los detalle de solicitud con productos fuera del catalogo  de la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<detalle_solicitud_PFDC> detalles_de_solicitud_PFDC(long id) {
		return detalleSolicitudDao.detalles_de_solicitud_PFDC(id); 
	}
	
	/*Servicio para guardar, crear, actualizar un detalle solicitud con productos fuera del catalogo 
	 *en la base de datos
	 **/
	@Override
	public detalle_solicitud_PFDC save(detalle_solicitud_PFDC ds) {
		return detalleSolicitudDao.save(ds);
	}
	
	/*Servicio para obtener los detalles de solicitud de una Solicitud con productos fuera del catalogo 
	 *(mediante id_solicitud)*/
	@Override
	public List<detalle_solicitud_PFDC> findAll() {
		return (List<detalle_solicitud_PFDC>) detalleSolicitudDao.findAll();
	}
}
