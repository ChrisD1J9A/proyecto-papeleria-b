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
	
	//Servicio para buscar todos los productos disponibles en la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {

		return (List<Producto>) productoDao.findAll();
	}
	
	//Servicio para guardar, almacenar, actualizar un producto en la base de datos
	@Override
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}
	
	//Servicio para buscar un producto mediante su identificador
	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
