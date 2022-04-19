package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeStock;

public interface IMaxMinDeStockService {
	
	public List<MaxMinDeStock> findAll();
	
	public MaxMinDeStock save (MaxMinDeStock maxMin);
	
	public MaxMinDeStock findById(Long id);
	
	public MaxMinDeStock findBySucursal (String sucursal);
}
