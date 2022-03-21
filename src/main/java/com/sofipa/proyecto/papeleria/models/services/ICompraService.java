package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.Compra;

public interface ICompraService {
	
	public List<Compra> findAll();
	
	public Compra save (Compra compra);
	
	public Compra findById(Long id);
	
	public List <Compra> findBySucursal(Long id);

}
