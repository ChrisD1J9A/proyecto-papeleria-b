package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;

public interface IDetalleInventarioDao extends CrudRepository<detalle_inventario, Long>{
	/*
	 * Se realiza una consulta en la base de datos que trata de buscar los detalles de inventario mediante el 
	 * id_inventario al cual se asocian
	 * */
	@Query(value= "SELECT * \r\n"
			+ "FROM detalle_inventario di\r\n"
			+ "WHERE di.id_inventario= :id", nativeQuery = true)
	List<detalle_inventario> detalles_de_iventario (@Param("id") long id);  
	
	/*
	 * Se realiza una consulta en la base de datos que trata de buscar todos los inventarios incluyendo sus detalles
	 * */
	@Query(value= "SELECT\r\n"
			+ "	i.id_inventario as 'Id_inventario',\r\n"
			+ "	i.nombre_sucursal as 'Sucursal',\r\n"
			+ "	p.descripcion as 'Productos',\r\n"
			+ "	di.cant_existente as 'Cantidad existente'\r\n"
			+ "FROM inventario i, detalle_inventario di\r\n"
			+ "JOIN productos p\r\n"
			+ "ON   di.id_producto = p.id_producto\r\n"
			+ "WHERE i.id_inventario = di.id_inventario\r\n"
			+ "ORDER BY i.id_sucursal ASC", nativeQuery = true)
	List<Object> todos_los_inventarios_ordenados ();
}
