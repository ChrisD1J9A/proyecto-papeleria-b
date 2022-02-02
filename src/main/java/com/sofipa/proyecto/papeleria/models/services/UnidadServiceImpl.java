package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IUnidadDao;
import com.sofipa.proyecto.papeleria.models.entity.Unidad;

@Service
public class UnidadServiceImpl implements IUnidadService{
	@Autowired
	private IUnidadDao unidadDao;
	@Override
	@Transactional(readOnly = true)
	public List<Unidad> findAll() {
		return (List<Unidad>) unidadDao.findAll();
	}
	
	@Override
	@Transactional
	public Unidad save(Unidad unidad) {
		return unidadDao.save(unidad);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Unidad findById(Long id) {
		return unidadDao.findById(id).orElse(null);
	}

}
