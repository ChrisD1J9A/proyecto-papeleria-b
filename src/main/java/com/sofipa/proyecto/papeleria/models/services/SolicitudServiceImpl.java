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
	
	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> findAll() {
		return (List<Solicitud>) solicitudDao.findAll();
	}

	@Override
	public Solicitud save(Solicitud solicitud) {
		return solicitudDao.save(solicitud);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Solicitud findById(Long id) {
		return solicitudDao.findById(id).orElse(null);
	}

}
