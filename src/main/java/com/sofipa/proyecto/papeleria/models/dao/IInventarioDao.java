package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.sofipa.proyecto.papeleria.models.entity.Inventario;

public interface IInventarioDao extends CrudRepository<Inventario, Long>{
	
}
