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
@Table(name = "maxMinDeStock")
public class MaxMinDeStock implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_maxMinDeStock;
	
	private Long id_sucursal;
	private String usuario_modifico;
	private int max_stock;
	private int min_stock;
	private String estatus; 

	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	@Column(name="fecha_actualizacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_actualizacion;
	
	public Long getId_maxMinDeStock() {
		return id_maxMinDeStock;
	}

	public void setId_maxMinDeStock(Long id_maxMinDeStock) {
		this.id_maxMinDeStock = id_maxMinDeStock;
	}

	public Long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getUsuario_modifico() {
		return usuario_modifico;
	}

	public void setUsuario_modifico(String usuario_modifico) {
		this.usuario_modifico = usuario_modifico;
	}

	public int getMax_stock() {
		return max_stock;
	}

	public void setMax_stock(int max_stock) {
		this.max_stock = max_stock;
	}

	public int getMin_stock() {
		return min_stock;
	}

	public void setMin_stock(int min_stock) {
		this.min_stock = min_stock;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
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
