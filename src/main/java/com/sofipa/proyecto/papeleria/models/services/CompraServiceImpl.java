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

	@Override
	public List <Compra> findBySucursal(Long id) {
		return compraDao.findBySucursal(id);
	}

	@Override
	public List<Object> maximoGastoDeComprasPorSucursal(int meses) {
		return compraDao.maximoGastoDeComprasPorSucursal(meses);
	}

	@Override
	public List<Object> maximoGastoDeComprasPorSucursalHistorico() {
		return  compraDao.maximoGastoDeComprasPorSucursalHistorico();
	}
	
	@Override
	public List<Object> maximoGastoDeComprasPorSucursalRangoFechas(String fecha1, String fecha2) {
		return compraDao.maximoGastoDeComprasPorSucursalRangoFechas(fecha1, fecha2);
	}

	@Override
	public List<Object> gastoTotalDeComprasPorSucursal(int meses) {
		return  compraDao.gastoTotalDeComprasPorSucursal(meses);
	}

	@Override
	public List<Object> gastoTotalDeComprasPorSucursalHistorico() {
		return  compraDao.gastoTotalDeComprasPorSucursalHistorico();
	}

	@Override
	public List<Object> gastoTotalDeComprasPorSucursalRangoFechas(String fecha1, String fecha2) {
		return  compraDao.gastoTotalDeComprasPorSucursalRangoFechas(fecha1, fecha2);
	}
}
