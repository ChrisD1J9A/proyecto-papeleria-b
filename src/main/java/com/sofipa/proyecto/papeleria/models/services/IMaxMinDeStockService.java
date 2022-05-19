package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeStock;

public interface IMaxMinDeStockService {
	
	//Servicio para obtener todas las configuraciones de la base de datos
	public List<MaxMinDeStock> findAll();
	
	//Servicio para guardar, almacenar o actualizar las configuraciones en la base de datos
	public MaxMinDeStock save (MaxMinDeStock maxMin);
	
	//Servicio para obtener una configuracion mediante su id
	public MaxMinDeStock findById(Long id);
	
	//Servicio para obtener una configuracion de una Sucursal en particular
	public MaxMinDeStock findBySucursal (String sucursal);
}
