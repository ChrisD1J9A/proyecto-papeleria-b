package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.dao.IMaxMinDeStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeStock;

@Service
public class MaxMinStockServiceImpl implements IMaxMinDeStockService{
	@Autowired
	private IMaxMinDeStockDao maxMinStockDao;
	
	//Servicio para obtener todas las configuraciones de la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<MaxMinDeStock> findAll() {
		return (List<MaxMinDeStock>) maxMinStockDao.findAll();
	}
	
	//Servicio para guardar, almacenar o actualizar las configuraciones en la base de datos
	@Override
	public MaxMinDeStock save(MaxMinDeStock maxMin) {
		return maxMinStockDao.save(maxMin);
	}
	
	//Servicio para obtener una configuracion mediante su id
	@Override
	public MaxMinDeStock findById(Long id) {
		return maxMinStockDao.findById(id).orElse(null);
	}
	
	//Servicio para obtener una configuracion de una Sucursal en particular
	@Override
	public MaxMinDeStock findBySucursal(String sucursal) {
		return maxMinStockDao.findBySucursal(sucursal);
	}
}
