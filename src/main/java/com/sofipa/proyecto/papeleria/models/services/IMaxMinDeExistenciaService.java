package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeExistencia;

public interface IMaxMinDeExistenciaService {
	
public List<MaxMinDeExistencia> findAll();
	
	public MaxMinDeExistencia save (MaxMinDeExistencia maxMin);
	
	public MaxMinDeExistencia findById(Long id);
	
	public MaxMinDeExistencia findBySucursal (String sucursal);
}
