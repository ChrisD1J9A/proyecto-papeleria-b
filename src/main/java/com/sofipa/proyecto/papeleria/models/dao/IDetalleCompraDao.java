package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;

public interface IDetalleCompraDao extends CrudRepository<detalle_compra, Long> {
	/*
	 * Se consulta en la base de datos todos los detalle de compra pertenecientes a una compra, por ello la busqueda mediante
	 * su id_compra
	 * */
	@Query(value= "SELECT * \r\n"
			+ "FROM detalle_compra dc\r\n"
			+ "WHERE dc.id_compra= :id", nativeQuery = true)
	List<detalle_compra> detalles_de_compra(@Param("id") long id);  
}
