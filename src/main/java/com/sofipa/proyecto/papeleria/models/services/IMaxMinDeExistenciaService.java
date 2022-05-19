package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeExistencia;

public interface IMaxMinDeExistenciaService {
	
	//Servicio para obtener todas las configuraciones de la base de datos
	public List<MaxMinDeExistencia> findAll();
	
	//Servicio para guardar, almacenar o actualizar las configuraciones en la base de datos
	public MaxMinDeExistencia save (MaxMinDeExistencia maxMin);
	
	//Servicio para obtener una configuracion mediante su id
	public MaxMinDeExistencia findById(Long id);
	
	//Servicio para obtener una configuracion de una Sucursal en particular
	public MaxMinDeExistencia findBySucursal (String sucursal);
}
