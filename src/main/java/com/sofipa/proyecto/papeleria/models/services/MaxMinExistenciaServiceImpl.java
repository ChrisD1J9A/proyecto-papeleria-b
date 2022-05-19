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
	
	//Servicio para obtener todas las configuraciones de la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<MaxMinDeExistencia> findAll() {
		return (List<MaxMinDeExistencia>) maxMinExistenciaDao.findAll();
	}

	//Servicio para guardar, almacenar o actualizar las configuraciones en la base de datos
	@Override
	public MaxMinDeExistencia save(MaxMinDeExistencia maxMin) {
		return maxMinExistenciaDao.save(maxMin);
	}

	//Servicio para obtener una configuracion mediante su id
	@Override
	public MaxMinDeExistencia findById(Long id) {
		return maxMinExistenciaDao.findById(id).orElse(null);
	}
	
	//Servicio para obtener una configuracion de una Sucursal en particular
	@Override
	public MaxMinDeExistencia findBySucursal(String sucursal) {
		return maxMinExistenciaDao.findBySucursal(sucursal);
	}
}
