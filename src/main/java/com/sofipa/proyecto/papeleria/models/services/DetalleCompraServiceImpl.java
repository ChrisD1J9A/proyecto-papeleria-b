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

	@Override
	public detalle_compra save(detalle_compra dc) {
		return detalleCompraDao.save(dc);
	}

	@Override
	@Transactional(readOnly = true)
	public List<detalle_compra> detalles_de_compra(long id) {
		return detalleCompraDao.detalles_de_compra(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<detalle_compra> soloDetallesCompra(long id) {
		return  detalleCompraDao.soloDetallesCompra(id);
	}

}
