package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.Compra;

public interface ICompraService {
	
	public List<Compra> findAll();
	
	public Compra save (Compra compra);
	
	public Compra findById(Long id);
	
	public List <Compra> findBySucursal(Long id);
	
	public List <Object> maximoGastoDeComprasPorSucursal(int meses);
	
	public List <Object> maximoGastoDeComprasPorSucursalHistorico();
	
	public List <Object> maximoGastoDeComprasPorSucursalRangoFechas(String fecha1, String fecha2);
	
	public List <Object> gastoTotalDeComprasPorSucursal(int meses);
	
	public List <Object> gastoTotalDeComprasPorSucursalHistorico();
	
	public List <Object> gastoTotalDeComprasPorSucursalRangoFechas(String fecha1, String fecha2);

}
