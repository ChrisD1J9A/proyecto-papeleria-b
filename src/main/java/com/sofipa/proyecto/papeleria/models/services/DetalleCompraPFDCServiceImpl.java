package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.IDetalleCompraPFDCDao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_pfdc;

@Service
public class DetalleCompraPFDCServiceImpl implements IDetalleCompraPFDCService{
	@Autowired
	private IDetalleCompraPFDCDao detalleCompraDao;
	
	/*Servicio para guardar, crear, actualizar un detalle compra con productos fuera del catalogo 
	 *en la base de datos*/
	@Override
	@Transactional(readOnly = true)
	public List<detalle_compra_pfdc> detalles_de_compra_pfdc(long id) {
		return detalleCompraDao.detalles_de_compra_pfdc(id); 
	}
	
	/*Servicio para obtener los detalles de compra con productos fuera del catalogo de una Compra 
	 *(mediante id_compra)*/
	@Override
	public detalle_compra_pfdc save(detalle_compra_pfdc ds) {
		return detalleCompraDao.save(ds);
	}
}
