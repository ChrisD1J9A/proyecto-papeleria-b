package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IProveedorDao;
import com.sofipa.proyecto.papeleria.models.entity.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{
	@Autowired
	private IProveedorDao proveedorDao;
	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findAll() {
		return  (List<Proveedor>)proveedorDao.findAll();
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		return proveedorDao.save(proveedor);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proveedor findById(Long id) {
		return proveedorDao.findById(id).orElse(null);
	}

}
