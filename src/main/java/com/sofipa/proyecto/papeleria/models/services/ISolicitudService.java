package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Solicitud;

public interface ISolicitudService {
public List<Solicitud> findAll();
	
	public Solicitud save (Solicitud solicitud);
	
	public void delete(Long id);
	
	public Solicitud findById(Long id);

}
