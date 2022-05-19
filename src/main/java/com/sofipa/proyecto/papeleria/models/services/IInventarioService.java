package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Inventario;

public interface IInventarioService {
	//Servicio para obtener todos los inventarios de la base de datos
	public List<Inventario> findAll();
	
	//Servicio para guardar, almacenar o actualizar un inventario en la base de datos
	public Inventario save (Inventario inventario);
	
	//Servicio para obtener un inventario mediante su identificador
	public Inventario findById(Long id);
	
	//Servicio para obtener un inventario perteneciente a una Sucursal en específico
	public Inventario findBySucursal(Long id);
}
