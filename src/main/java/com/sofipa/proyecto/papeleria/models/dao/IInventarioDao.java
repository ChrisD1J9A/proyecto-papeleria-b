package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.sofipa.proyecto.papeleria.models.entity.Inventario;

public interface IInventarioDao extends CrudRepository<Inventario, Long>{
	
	/*
	 * Se consulta en la base de datos un inventario de una sucursal en específico
	 * */
	Inventario findByIdSucursal(long id);  
}
