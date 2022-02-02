package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.Proveedor;

public interface IProveedorService {
	public List<Proveedor> findAll();
	
	public Proveedor save(Proveedor proveedor);
	
	public void delete (Long id);
	
	public Proveedor findById(Long id);
}
