package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofipa.proyecto.papeleria.models.dao.IInventarioDao;
import com.sofipa.proyecto.papeleria.models.entity.Inventario;

@Service
public class InventarioServiceImpl implements IInventarioService{
	@Autowired
	private IInventarioDao inventarioDao;

	//Servicio para obtener todos los inventarios de la base de datos
	@Override
	public List<Inventario> findAll() {
		return (List<Inventario>) inventarioDao.findAll();
	}

	//Servicio para guardar, almacenar o actualizar un inventario en la base de datos
	@Override
	public Inventario save(Inventario inventario) {
		return inventarioDao.save(inventario);
	}

	//Servicio para obtener un inventario mediante su identificador
	@Override
	public Inventario findById(Long id) {
		return inventarioDao.findById(id).orElse(null);
	}

	//Servicio para obtener un inventario perteneciente a una Sucursal en específico
	@Override
	public Inventario findBySucursal(Long id) {
		return inventarioDao.findBySucursal(id);
	}

}
