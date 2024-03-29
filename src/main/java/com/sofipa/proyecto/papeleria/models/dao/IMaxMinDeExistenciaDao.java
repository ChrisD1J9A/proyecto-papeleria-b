package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeExistencia;

public interface IMaxMinDeExistenciaDao extends CrudRepository<MaxMinDeExistencia, Long>{
	/*
	 * Se realiza una consulta en la base de datos en donde se obtiene la configuracion de una determinada sucursal
	 * */
	@Query(value= "SELECT * \r\n"
			+ "FROM max_min_de_existencia MNE\r\n"
			+ "WHERE MNE.sucursal= :sucursal AND MNE.estatus=1", nativeQuery = true)
	MaxMinDeExistencia findBySucursal (@Param("sucursal") String sucursal);

}
