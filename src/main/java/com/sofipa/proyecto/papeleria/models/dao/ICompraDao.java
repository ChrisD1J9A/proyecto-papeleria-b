package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sofipa.proyecto.papeleria.models.entity.Compra;

public interface ICompraDao extends CrudRepository<Compra, Long>{
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.compras C\r\n"
			+ "WHERE C.id_sucursal = :id", nativeQuery = true)
	List <Compra> findBySucursal(@Param("id") long id);
	
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, c.fecha_creacion, MAX(c.gasto_total) as Maximo \r\n"
			   + "FROM db_papeleria.compras c\r\n"
			   + "WHERE c.fecha_creacion >= date_sub(now(), interval :meses month)\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> maximoGastoDeComprasPorSucursal(@Param("meses") int meses);
	
	
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, c.fecha_creacion, MAX(c.gasto_total) as Maximo \r\n"
			   + "FROM db_papeleria.compras c\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> maximoGastoDeComprasPorSucursalHistorico();
	
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, c.fecha_creacion, MAX(c.gasto_total) as Maximo \r\n"
			   + "FROM db_papeleria.compras c\r\n"
			   + "WHERE c.fecha_creacion BETWEEN :fecha1 AND :fecha2\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC;", nativeQuery = true)
	List <Object> maximoGastoDeComprasPorSucursalRangoFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
	
	
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, SUM(c.gasto_total) as Gasto_total \r\n"
			   + "FROM db_papeleria.compras c\r\n"
			   + "WHERE c.fecha_creacion >= date_sub(now(), interval :meses month)\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> gastoTotalDeComprasPorSucursal(@Param("meses") int meses);
	
	@Query(value="SELECT c.id_compra, c.nombre_sucursal, SUM(c.gasto_total) as Gasto_total \r\n"
			   + "FROM db_papeleria.compras c\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> gastoTotalDeComprasPorSucursalHistorico();
	
	@Query(value="SELECT c.nombre_sucursal, SUM(c.gasto_total) as Gasto_total \r\n"
			   + "FROM db_papeleria.compras c\r\n"
			   + "WHERE c.fecha_creacion BETWEEN :fecha1 AND :fecha2\r\n"
			   + "GROUP BY c.nombre_sucursal\r\n"
			   + "ORDER BY c.gasto_total DESC", nativeQuery = true)
	List <Object> gastoTotalDeComprasPorSucursalRangoFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
		
}
