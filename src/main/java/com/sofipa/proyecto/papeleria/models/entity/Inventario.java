package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {
	/*
	 *la entidad Inventario donde se detallan sus atributos, sus respectivos métodos set y get 
	 *así como se define las columnas de la tabla que representa la entidad para la base de datos, 
	 *para el caso de Inventario sus atributos son: id_inventario, id_sucursal, nombre_sucursal y fecha_ultima_actualizacion. 
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_inventario;

	@Column(name = "id_sucursal")
	private Long idSucursal;
	
	@Column(name = "nombre_sucursal")
	private String nombre_sucursal;

	@Column(name = "fecha_ultima_actualizacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_ultima_actualizacion;

	public Long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long id_sucursal) {
		this.idSucursal = id_sucursal;
	}

	public String getNombre_sucursal() {
		return nombre_sucursal;
	}

	public void setNombre_sucursal(String nombre_sucursal) {
		this.nombre_sucursal = nombre_sucursal;
	}

	public Date getFecha_ultima_actualizacion() {
		return fecha_ultima_actualizacion;
	}

	public void setFecha_ultima_actualizacion(Date fecha_ultima_actualizacion) {
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
	}

	private static final long serialVersionUID = 1L;
}
