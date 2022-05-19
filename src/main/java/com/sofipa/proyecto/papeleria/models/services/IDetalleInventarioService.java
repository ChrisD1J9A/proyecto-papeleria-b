package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;

public interface IDetalleInventarioService {
	//Servicio para guardar, almacenar o actualizar un detalle de inventario en la base de datos
	public detalle_inventario save (detalle_inventario ds);
	
	//Servicio para obtener los detalles de inventario partiendo del Inventario(id_inventario) 
	//al que se asocian en la base de datos
	public List<detalle_inventario> detalles_de_inventario (long id);
	
	//Servicio para obtener todos los inventarios de menera ordenada y con informacion especifica de la base de datos
	public List<Object> todos_los_inventarios_ordenados ();
 
}
