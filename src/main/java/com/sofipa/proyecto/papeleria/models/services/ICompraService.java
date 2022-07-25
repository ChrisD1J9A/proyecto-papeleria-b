package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.Compra;

public interface ICompraService {
	//Servicio para obtener todas las compras de la base de datos
	public List<Compra> findAll();
	
	//Servicio para guardar, almacenar o actualizar una compra en la base de datos
	public Compra save (Compra compra);
	
	//Servicio para obtener una compra mediante su identificador
	public Compra findById(Long id);
	
	//Servicio para obtener las compras pertenecientes a una Sucursal en específico
	public List <Compra> findByIdSucursal(Long id);
	
	/*Servicio para obtener compras con mayores gastos en las sucursales y en un intervalo de tiempo
	 * específico, por ejemplo los últimos 6 meses 
	 * */
	public List <Object> maximoGastoDeComprasPorSucursal(int meses);
	
	//Servicio para obtener las compras con mayores gastos en las sucursales sin intervalos de tiempo(Histórico)
	public List <Object> maximoGastoDeComprasPorSucursalHistorico();
	
	/*Servicio para obtener las compras con mayores gastos de las sucursales
	 * de acuerdo a un rango de fechas especificados
	 * */
	public List <Object> maximoGastoDeComprasPorSucursalRangoFechas(String fecha1, String fecha2);
	
	 /*Servicio para obtener el gasto total efectuado en las compras de cada sucursal en un intervalo de tiempo
	 * por ejemplo en los últimos 6 meses
	 * */
	public List <Object> gastoTotalDeComprasPorSucursal(int meses);
	
	//Servicio para obtener el gasto total efectuado en las compras de cada sucursal desde siempre (Histórico)
	public List <Object> gastoTotalDeComprasPorSucursalHistorico();
	
	/*Servicio para obtener el gasto total efectuado en las compras de cada sucursal en un rango de fechas 
	 * en específico*/
	public List <Object> gastoTotalDeComprasPorSucursalRangoFechas(String fecha1, String fecha2);
	
	/*Servicio para obtener todas las compras realizadas en un periodo de tiempo por ejemplo en los últimos
	 * 6 meses */
	public List <Compra> comprasPorTiempo(int meses);
	
	//Servicio para obtener todas las compras realizadas en un rango de fechas 
	public List <Compra> comprasPorRangoFechas(String fecha1, String fecha2); 
	
	//Servicio para obtener de la base de datos las compras de acuerdo a cierto estatus
	public List <Compra> findByEstatus(String estatus);
}
