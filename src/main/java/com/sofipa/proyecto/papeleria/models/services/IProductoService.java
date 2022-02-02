package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	
	public Producto save (Producto producto);
	
	public void delete(Long id);
	
	public Producto findById(Long id);
}
