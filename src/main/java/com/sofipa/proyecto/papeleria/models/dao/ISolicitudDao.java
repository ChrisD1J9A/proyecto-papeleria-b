package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sofipa.proyecto.papeleria.models.entity.Solicitud;

public interface ISolicitudDao extends CrudRepository<Solicitud, Long>{
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.solicitudes S\r\n"
			+ "WHERE S.id_sucursal = :id", nativeQuery = true)
	List <Solicitud> findBySucursal(@Param("id") long id);
}
