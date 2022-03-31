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
@Table(name = "maxMinDeExistencia")
public class MaxMinDeExistencia implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_maxMinDeExistencia;

	private String sucursal;
	private String usuario_modifico;
	private int max_existencia;
	private int min_existencia;
	private int estatus;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;

	@Column(name = "fecha_actualizacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_actualizacion;

	public Long getId_maxMinDeExistencia() {
		return id_maxMinDeExistencia;
	}

	public void setId_maxMinDeExistencia(Long id_maxMinDeExistencia) {
		this.id_maxMinDeExistencia = id_maxMinDeExistencia;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getUsuario_modifico() {
		return usuario_modifico;
	}

	public void setUsuario_modifico(String usuario_modifico) {
		this.usuario_modifico = usuario_modifico;
	}

	public int getMax_existencia() {
		return max_existencia;
	}

	public void setMax_existencia(int max_existencia) {
		this.max_existencia = max_existencia;
	}

	public int getMin_existencia() {
		return min_existencia;
	}

	public void setMin_existencia(int min_existencia) {
		this.min_existencia = min_existencia;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	private static final long serialVersionUID = 1L;
}
