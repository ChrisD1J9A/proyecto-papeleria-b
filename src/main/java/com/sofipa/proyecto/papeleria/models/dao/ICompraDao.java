package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sofipa.proyecto.papeleria.models.entity.Compra;

public interface ICompraDao extends CrudRepository<Compra, Long>{
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.compras C\r\n"
			+ "WHERE C.id_sucursal = :id", nativeQuery = true)
	Compra findBySucursal(@Param("id") long id);
}
