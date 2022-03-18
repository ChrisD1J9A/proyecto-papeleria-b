package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;

import com.sofipa.proyecto.papeleria.models.entity.Inventario;

public interface IInventarioService {
	
	public List<Inventario> findAll();
	
	public Inventario save (Inventario inventario);
	
	public Inventario findById(Long id);
	
	public Inventario findBySucursal(Long id);
}
