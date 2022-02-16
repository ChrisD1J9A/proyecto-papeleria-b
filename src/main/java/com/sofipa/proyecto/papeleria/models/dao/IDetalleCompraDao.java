package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;

public interface IDetalleCompraDao extends CrudRepository<detalle_compra, Long> {
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_compra dc\r\n"
			+ "WHERE dc.id_compra= :id", nativeQuery = true)
	List<detalle_compra> detalles_de_compra(@Param("id") long id);  
	
	@Query(value = "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_compra dc\r\n"
			+ "WHERE dc.id_compra = :id", nativeQuery = true)
	List<detalle_compra> soloDetallesCompra(@Param("id") long id);
}
