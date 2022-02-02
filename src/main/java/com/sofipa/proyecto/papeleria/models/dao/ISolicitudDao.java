package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.sofipa.proyecto.papeleria.models.entity.Solicitud;

public interface ISolicitudDao extends CrudRepository<Solicitud, Long>{

}
