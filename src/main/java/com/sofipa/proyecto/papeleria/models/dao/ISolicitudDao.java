package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;
//import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import com.sofipa.proyecto.papeleria.models.entity.Solicitud;

public interface ISolicitudDao extends CrudRepository<Solicitud, Long>{
	
	/*
	 * Consulta en la base de datos que devuelve todas las solicitudes de una determinada sucursal
	 * la busqueda se realiza tomando en cuenta el id_sucursal
	 * */
	List <Solicitud> findByIdSucursal(/*@Param("id")*/ Long id);
	
	/*
	 * Consulta en la base de datos que devuelve todas las solicitudes de una determinado estatus
	 * la busqueda se realiza tomando en cuenta el atributo estatus
	 * */
	List <Solicitud> findByEstatus(String estatus);
	
	/*
	 * Consulta en la base de datos que devuelve todas las solicitudes de una determinada sucursal
	 * la busqueda se realiza tomando en cuenta el id_sucursal y el estatus de la solicitud 
	 * */
	List <Solicitud> findByIdSucursalAndEstatus(Long id, String estatus);
}
