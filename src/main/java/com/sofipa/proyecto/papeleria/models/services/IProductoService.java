package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Producto;

public interface IProductoService {
	//Servicio para buscar todos los productos disponibles en la base de datos
	public List<Producto> findAll();
	
	//Servicio para guardar, almacenar, actualizar un producto en la base de datos
	public Producto save (Producto producto);
	
	//Servicio para buscar un producto mediante su identificador
	public Producto findById(Long id);
}
