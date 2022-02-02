package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IDetalleSolicitudDao extends CrudRepository<detalle_solicitud, Long>{
	
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_solicitud ds\r\n"
			+ "WHERE ds.id_solicitud=1;", nativeQuery = true)
	List<detalle_solicitud> detalles_de_solicitud(@Param("id_solicitud") long id);  
}
