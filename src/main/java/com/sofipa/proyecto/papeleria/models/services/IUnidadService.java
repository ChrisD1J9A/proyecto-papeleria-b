package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Unidad;

public interface IUnidadService {
	
	//Servicio para obtener todas las unidades disponibles en la base de datos
	public List<Unidad> findAll();
		
	//Servicio para Guardar, almacenar o actualizar una Unidad en la base de datos
	public Unidad save (Unidad unidad);
	
	//Servicio para buscar una unidad mediante su id
	public Unidad findById(Long id);
}
