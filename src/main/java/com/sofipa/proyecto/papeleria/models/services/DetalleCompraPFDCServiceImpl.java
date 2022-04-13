package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IDetalleCompraPFDCDao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_PFDC;

@Service
public class DetalleCompraPFDCServiceImpl implements IDetalleCompraPFDCService{
	@Autowired
	private IDetalleCompraPFDCDao detalleCompraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<detalle_compra_PFDC> detalles_de_compra_PFDC(long id) {
		return detalleCompraDao.detalles_de_compra_PFDC(id); 
	}

	@Override
	public detalle_compra_PFDC save(detalle_compra_PFDC ds) {
		return detalleCompraDao.save(ds);
	}
}
