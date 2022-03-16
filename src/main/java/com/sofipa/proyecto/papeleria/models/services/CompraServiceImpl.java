package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.dao.ICompraDao;
import com.sofipa.proyecto.papeleria.models.entity.Compra;

@Service
public class CompraServiceImpl implements ICompraService{
	@Autowired
	private ICompraDao compraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Compra> findAll()
	{
		return (List<Compra>) compraDao.findAll();
	}

	@Override
	public Compra save(Compra compra) {
		return compraDao.save(compra);
	}

	@Override
	public Compra findById(Long id) {
		return compraDao.findById(id).orElse(null);
	}
}
