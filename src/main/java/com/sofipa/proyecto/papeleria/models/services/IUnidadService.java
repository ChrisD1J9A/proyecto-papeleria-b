package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Unidad;

public interface IUnidadService {
	public List<Unidad> findAll();
	
	public Unidad save (Unidad unidad);
	
	public void delete(Long id);
	
	public Unidad findById(Long id);
}
