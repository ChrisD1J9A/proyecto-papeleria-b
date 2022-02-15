package com.sofipa.proyecto.papeleria.models.dao;

import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IDetalleSolicitudDao extends CrudRepository<detalle_solicitud, Long>{
	
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_solicitud ds\r\n"
			+ "WHERE ds.id_solicitud= :id", nativeQuery = true)
	List<detalle_solicitud> detalles_de_solicitud(@Param("id") long id);  
	
	@Query(value = "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_solicitud ds\r\n"
			+ "WHERE ds.id_solicitud = :id", nativeQuery = true)
	List<detalle_solicitud> soloDetallesSolicitud(@Param("id") long id);
}
