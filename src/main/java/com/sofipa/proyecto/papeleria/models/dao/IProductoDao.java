package com.sofipa.proyecto.papeleria.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sofipa.proyecto.papeleria.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

}
