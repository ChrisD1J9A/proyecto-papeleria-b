package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeStock;

public interface IMaxMinDeStockDao extends CrudRepository<MaxMinDeStock, Long>{
	@Query(value= "SELECT * \r\n"
				+ "FROM db_papeleria.max_min_de_stock MNS\r\n"
				+ "WHERE MNS.sucursal= :sucursal AND MNS.estatus=1", nativeQuery = true)
	MaxMinDeStock findBySucursal (@Param("sucursal") String sucursal);
}
