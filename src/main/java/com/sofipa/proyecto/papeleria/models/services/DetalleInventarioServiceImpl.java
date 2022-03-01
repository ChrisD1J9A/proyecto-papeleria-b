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
	
	@Override
	public detalle_inventario save(detalle_inventario di) {
		return detalleInventarioDao.save(di);
	}

	@Override
	@Transactional(readOnly = true)
	public List<detalle_inventario> detalles_de_inventario(long id) {
		return detalleInventarioDao.detalles_de_iventario(id);
	}

}
