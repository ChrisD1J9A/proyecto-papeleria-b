package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.proyecto.papeleria.models.dao.ISolicitudDao;
import com.sofipa.proyecto.papeleria.models.entity.Solicitud;

@Service
public class SolicitudServiceImpl implements ISolicitudService{
	@Autowired
	private ISolicitudDao solicitudDao;
	
	//Servicio para obtener todas las Solicitudes de la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> findAll() {
		return (List<Solicitud>) solicitudDao.findAll();
	}
	
	//Servicio para guardar, almacenar, actualizar una solicitud
	@Override
	public Solicitud save(Solicitud solicitud) {
		return solicitudDao.save(solicitud);
	}

	//Servicio para buscar una solicitud mediane su identificador
	@Override
	public Solicitud findById(Long id) {
		return solicitudDao.findById(id).orElse(null);
	}
	
	//Servicio para buscar las solicitudes de una sucursal
	@Override
	public List<Solicitud> findBySucursal(Long id) {
		return solicitudDao.findBySucursal(id);
	}

}
