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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_inventario;

	@Column(name = "id_sucursal")
	private Long id_sucursal;

	@Column(name = "fecha_ultima_actualizacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_ultima_actualizacion;

	public Long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public Long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public Date getFecha_ultima_actualizacion() {
		return fecha_ultima_actualizacion;
	}

	public void setFecha_ultima_actualizacion(Date fecha_ultima_actualizacion) {
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
	}

	private static final long serialVersionUID = 1L;
}