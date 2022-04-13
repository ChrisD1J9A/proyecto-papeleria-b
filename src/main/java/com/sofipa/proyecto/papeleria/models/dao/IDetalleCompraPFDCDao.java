package com.sofipa.proyecto.papeleria.models.dao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_PFDC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IDetalleCompraPFDCDao extends CrudRepository<detalle_compra_PFDC, Long>{
	
	@Query(value= "SELECT * \r\n"
			+ "FROM db_papeleria.detalle_compra_PFDC ds\r\n"
			+ "WHERE ds.id_compra= :id", nativeQuery = true)
	List<detalle_compra_PFDC> detalles_de_compra_PFDC (@Param("id") long id);  
}
