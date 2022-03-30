package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IMaxMinDeExistenciaDao;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeExistencia;

@Service
public class MaxMinExistenciaServiceImpl implements IMaxMinDeExistenciaService{
	@Autowired
	private IMaxMinDeExistenciaDao maxMinExistenciaDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<MaxMinDeExistencia> findAll() {
		return (List<MaxMinDeExistencia>) maxMinExistenciaDao.findAll();
	}

	@Override
	public MaxMinDeExistencia save(MaxMinDeExistencia maxMin) {
		return maxMinExistenciaDao.save(maxMin);
	}

	@Override
	public MaxMinDeExistencia findById(Long id) {
		return maxMinExistenciaDao.findById(id).orElse(null);
	}

	@Override
	public MaxMinDeExistencia existeSucursal(String sucursal) {
		return maxMinExistenciaDao.existeSucursal(sucursal);
	}
}
