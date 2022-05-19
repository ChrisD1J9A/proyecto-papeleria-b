package com.sofipa.proyecto.papeleria.models.dao;

import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud_PFDC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IDetalleSolicitudPFDCDao extends CrudRepository<detalle_solicitud_PFDC, Long>{
	/*
	 * Consulta en la base de datos la cual busca todos los detalles de solicitud con productos fuera del catalogo
	 * de acuerdo al id_solicitud,
	 * */
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_solicitud_PFDC ds\r\n"
			+ "WHERE ds.id_solicitud= :id", nativeQuery = true)
	List<detalle_solicitud_PFDC> detalles_de_solicitud_PFDC (@Param("id") long id);  
}
