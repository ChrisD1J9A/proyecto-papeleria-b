package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.Proveedor;

public interface IProveedorService {
	//Servicio para obtener todos los proveedores de la base de datos
	public List<Proveedor> findAll();
	
	//Servicio para guardar, almacenar, actualizar un proveedor
	public Proveedor save(Proveedor proveedor);
	
	//Servicio para buscar un proveedor mediane su identificador
	public Proveedor findById(Long id);
}
