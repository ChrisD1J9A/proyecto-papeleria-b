package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Solicitud;

public interface ISolicitudService {
	
	//Servicio para obtener todas las Solicitudes de la base de datos
	public List<Solicitud> findAll();
	
	//Servicio para guardar, almacenar, actualizar una solicitud
	public Solicitud save (Solicitud solicitud);
	
	//Servicio para buscar una solicitud mediane su identificador
	public Solicitud findById(Long id);
	
	//Servicio para buscar las solicitudes de una sucursal
	public List<Solicitud> findBySucursal(Long id);

}
