package com.sofipa.proyecto.papeleria.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;

public interface IDetalleInventarioDao extends CrudRepository<detalle_inventario, Long>{
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_inventario di\r\n"
			+ "WHERE di.id_inventario= :id", nativeQuery = true)
	List<detalle_inventario> detalles_de_iventario (@Param("id") long id);  

	@Query(value= "SELECT i.nombre_sucursal, i.id_inventario, di.id_producto, di.cant_existente FROM inventario i, detalle_inventario di ORDER BY i.id_sucursal ASC;", nativeQuery = true)
	List<Object> todos_los_inventarios_ordenados ();
}
