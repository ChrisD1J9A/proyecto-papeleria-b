package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IDetalleInventarioDao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;

@Service
public class DetalleInventarioServiceImpl  implements IDetalleInventarioService{
	@Autowired
	private IDetalleInventarioDao detalleInventarioDao;
	
	//Servicio para guardar, almacenar o actualizar un detalle de inventario en la base de datos
	@Override
	public detalle_inventario save(detalle_inventario di) {
		return detalleInventarioDao.save(di);
	}
	
	//Servicio para obtener los detalles de inventario partiendo del Inventario(id_inventario) 
	//al que se asocian en la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<detalle_inventario> detalles_de_inventario(long id) {
		return detalleInventarioDao.detalles_de_iventario(id);
	}
	
	//Servicio para obtener todos los inventarios de menera ordenada y con informacion especifica de la base de datos
	@Override
	public List<Object> todos_los_inventarios_ordenados() {
		return detalleInventarioDao.todos_los_inventarios_ordenados();
	}

}
