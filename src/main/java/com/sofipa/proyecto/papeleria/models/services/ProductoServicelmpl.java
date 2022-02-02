package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IProductoDao;
import com.sofipa.proyecto.papeleria.models.entity.Producto;

@Service
public class ProductoServicelmpl implements IProductoService{
	@Autowired
	private IProductoDao productoDao;
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {

		return (List<Producto>) productoDao.findAll();
	}
	@Override
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
