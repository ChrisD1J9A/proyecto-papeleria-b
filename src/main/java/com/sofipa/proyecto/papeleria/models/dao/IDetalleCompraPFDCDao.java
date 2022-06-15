package com.sofipa.proyecto.papeleria.models.dao;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_pfdc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IDetalleCompraPFDCDao extends CrudRepository<detalle_compra_pfdc, Long>{
	
	/*
	 * Se consulta en la base de datos todos los detalle de compra con productos fuera del catalogo
	 *  pertenecientes a una compra, por ello la busqueda mediante su id_compra
	 * */
	@Query(value= "SELECT * \r\n"
			+ "FROM detalle_compra_pfdc dc\r\n"
			+ "WHERE dc.id_compra= :id", nativeQuery = true)
	List<detalle_compra_pfdc> detalles_de_compra_pfdc (@Param("id") long id);  
}
