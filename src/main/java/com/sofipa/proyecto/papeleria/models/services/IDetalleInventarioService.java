package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;

public interface IDetalleInventarioService {
	public detalle_inventario save (detalle_inventario ds);
	public List<detalle_inventario> detalles_de_inventario (long id);

}
