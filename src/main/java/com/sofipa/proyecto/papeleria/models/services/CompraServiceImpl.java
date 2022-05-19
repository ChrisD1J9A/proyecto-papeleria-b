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
	
	//Servicio para obtener todas las compras de la base de datos
	@Override
	@Transactional(readOnly = true)
	public List<Compra> findAll()
	{
		return (List<Compra>) compraDao.findAll();
	}
	
	//Servicio para guardar, almacenar o actualizar una compra en la base de datos
	@Override
	public Compra save(Compra compra) {
		return compraDao.save(compra);
	}
	
	//Servicio para obtener una compra mediante su identificador
	@Override
	public Compra findById(Long id) {
		return compraDao.findById(id).orElse(null);
	}
	
	//Servicio para obtener las compras pertenecientes a una Sucursal en específico
	@Override
	public List <Compra> findBySucursal(Long id) {
		return compraDao.findBySucursal(id);
	}
	
	/*Servicio para obtener compras con mayores gastos en las sucursales y en un intervalo de tiempo
	 * específico, por ejemplo los últimos 6 meses 
	 * */
	@Override
	public List<Object> maximoGastoDeComprasPorSucursal(int meses) {
		return compraDao.maximoGastoDeComprasPorSucursal(meses);
	}
	
	//Servicio para obtener las compras con mayores gastos en las sucursales sin intervalos de tiempo(Histórico)
	@Override
	public List<Object> maximoGastoDeComprasPorSucursalHistorico() {
		return  compraDao.maximoGastoDeComprasPorSucursalHistorico();
	}
	
	/*Servicio para obtener las compras con mayores gastos de las sucursales
	 * de acuerdo a un rango de fechas especificados
	 * */
	@Override
	public List<Object> maximoGastoDeComprasPorSucursalRangoFechas(String fecha1, String fecha2) {
		return compraDao.maximoGastoDeComprasPorSucursalRangoFechas(fecha1, fecha2);
	}
	
	/*Servicio para obtener el gasto total efectuado en las compras de cada sucursal en un intervalo de tiempo
	 * por ejemplo en los últimos 6 meses
	 * */
	@Override
	public List<Object> gastoTotalDeComprasPorSucursal(int meses) {
		return  compraDao.gastoTotalDeComprasPorSucursal(meses);
	}
	
	//Servicio para obtener el gasto total efectuado en las compras de cada sucursal desde siempre (Histórico)
	@Override
	public List<Object> gastoTotalDeComprasPorSucursalHistorico() {
		return  compraDao.gastoTotalDeComprasPorSucursalHistorico();
	}
	
	/*Servicio para obtener el gasto total efectuado en las compras de cada sucursal en un rango de fechas 
	 * en específico*/
	@Override
	public List<Object> gastoTotalDeComprasPorSucursalRangoFechas(String fecha1, String fecha2) {
		return  compraDao.gastoTotalDeComprasPorSucursalRangoFechas(fecha1, fecha2);
	}
	
	/*Servicio para obtener todas las compras realizadas en un periodo de tiempo por ejemplo en los últimos
	 * 6 meses */
	@Override
	public List<Compra> comprasPorTiempo(int meses) {
		return compraDao.comprasPorTiempo(meses);
	}
	
	//Servicio para obtener todas las compras realizadas en un rango de fechas 
	@Override
	public List<Compra> comprasPorRangoFechas(String fecha1, String fecha2) {
		return compraDao.comprasPorRangoFechas(fecha1, fecha2);
	}
}
