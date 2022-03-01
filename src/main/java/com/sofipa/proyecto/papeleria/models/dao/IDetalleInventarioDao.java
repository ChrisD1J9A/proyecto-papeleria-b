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

}
