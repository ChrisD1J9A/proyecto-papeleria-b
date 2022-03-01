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

	@Override
	public List<Inventario> findAll() {
		return (List<Inventario>) inventarioDao.findAll();
	}

	@Override
	public Inventario save(Inventario inventario) {
		return inventarioDao.save(inventario);
	}

	@Override
	public Inventario findById(Long id) {
		return inventarioDao.findById(id).orElse(null);
	}

}
