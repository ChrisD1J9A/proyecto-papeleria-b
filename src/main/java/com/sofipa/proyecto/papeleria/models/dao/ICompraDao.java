package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sofipa.proyecto.papeleria.models.entity.Compra;

public interface ICompraDao extends CrudRepository<Compra, Long>{
	/*
	 * Se busca en la base de datos las compras pertenecientes a una Sucursal en específico
	 * */
	List <Compra> findByIdSucursal(long id);
	
	/*
	 * Se consulta en la base de datos las compras con mayores gastos en las sucursales y en un intervalo de tiempo
	 * específico, por ejemplo los últimos 6 meses 
	 * */
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, c.fecha_creacion, MAX(c.gasto_total) as Maximo \r\n"
			   + "FROM compras c\r\n"
			   + "WHERE c.fecha_creacion >= date_sub(now(), interval :meses month)\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> maximoGastoDeComprasPorSucursal(@Param("meses") int meses);
	
	/*
	 *Se consulta en la base de datos las compras con mayores gastos en las sucursales sin intervalos de tiempo(Histórico)
	 * */
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, c.fecha_creacion, MAX(c.gasto_total) as Maximo \r\n"
			   + "FROM compras c\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> maximoGastoDeComprasPorSucursalHistorico();
	
	/*
	 * Se realiza la consulta en la base de datos las compras con mayores gastos de las sucursales
	 * de acuerdo a un rango de fechas especificados
	 * */
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, c.fecha_creacion, MAX(c.gasto_total) as Maximo \r\n"
			   + "FROM compras c\r\n"
			   + "WHERE c.fecha_creacion BETWEEN :fecha1 AND :fecha2\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC;", nativeQuery = true)
	List <Object> maximoGastoDeComprasPorSucursalRangoFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
	
	/*
	 * Se consulta en la base de datos el gasto total efectuado en las compras de cada sucursal en un intervalo de tiempo
	 * por ejemplo en los últimos 6 meses
	 * */
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, SUM(c.gasto_total) as Gasto_total \r\n"
			   + "FROM compras c\r\n"
			   + "WHERE c.fecha_creacion >= date_sub(now(), interval :meses month)\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> gastoTotalDeComprasPorSucursal(@Param("meses") int meses);
	
	/*
	 * Se consulta en la base de datos el gasto total efectuado en las compras de cada sucursal desde siempre (Histórico)
	 * */
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, SUM(c.gasto_total) as Gasto_total \r\n"
			   + "FROM compras c\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> gastoTotalDeComprasPorSucursalHistorico();
	
	/*
	 * Se consulta en la base de datos el gasto total efectuado en las compras de cada sucursal en un rango de fechas 
	 * en específico
	 * */
	@Query(value="SELECT  c.id_compra, c.nombre_sucursal, SUM(c.gasto_total) as Gasto_total \r\n"
			   + "FROM compras c\r\n"
			   + "WHERE c.fecha_creacion BETWEEN :fecha1 AND :fecha2\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> gastoTotalDeComprasPorSucursalRangoFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
	
	/*
	 * Se consulta en la base de datos todas las compras realizadas en un periodo de tiempo por ejemplo en los últimos
	 * 6 meses 
	 * */
	@Query(value="SELECT *\r\n"
				+ "FROM compras c\r\n"
				+ "WHERE c.fecha_creacion >= date_sub(now(), interval :meses month)", nativeQuery = true)
	List <Compra> comprasPorTiempo(@Param("meses") int meses);
	
	/*
	 * Se consulta en la base de datos todas las compras realizadas en un rango de fechas 
	 * */
	@Query(value="SELECT * \r\n"
			   + "FROM compras c\r\n"
			   + "WHERE c.fecha_creacion BETWEEN :fecha1 AND :fecha2", nativeQuery = true)
	List <Compra> comprasPorRangoFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
}
