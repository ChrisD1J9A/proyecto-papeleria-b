package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	
	@ManyToOne(optional= false, fetch= FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Unidad unidad;
	@Column
	private String descripcion;
	private float precio_iva;
	private float precio_subtotal;
	private float precio_total;
	private int estatus;
	private String observaciones;

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}


	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio_iva() {
		return precio_iva;
	}

	public void setPrecio_iva(float precio_iva) {
		this.precio_iva = precio_iva;
	}

	public float getPrecio_subtotal() {
		return precio_subtotal;
	}

	public void setPrecio_subtotal(float precio_subtotal) {
		this.precio_subtotal = precio_subtotal;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	private static final long serialVersionUID = 1L;

}
