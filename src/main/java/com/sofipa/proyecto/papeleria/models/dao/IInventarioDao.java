package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.sofipa.proyecto.papeleria.models.entity.Inventario;

public interface IInventarioDao extends CrudRepository<Inventario, Long>{
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.inventario i\r\n"
			+ "WHERE i.id_inventario = :id", nativeQuery = true)
	Inventario findBySucursal(@Param("id") long id);  
}
