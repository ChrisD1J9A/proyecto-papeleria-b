package com.sofipa.proyecto.papeleria.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.proyecto.papeleria.models.dao.IDetalleCompraDao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;

import java.util.List;

@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService{
	@Autowired
	private IDetalleCompraDao detalleCompraDao;
	
	//Servicio para guardar, crear, actualizar un detalle compra en la base de datos
	@Override
	public detalle_compra save(detalle_compra dc) {
		return detalleCompraDao.save(dc);
	}
	
	//Servicio para obtener los detalles de compra de una Compra (mediante id_compra)
	@Override
	@Transactional(readOnly = true)
	public List<detalle_compra> detalles_de_compra(long id) {
		return detalleCompraDao.detalles_de_compra(id);
	}
}
