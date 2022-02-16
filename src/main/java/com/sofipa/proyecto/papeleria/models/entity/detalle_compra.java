package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_compra")
public class detalle_compra implements Serializable {
	@EmbeddedId
	private CompraDetallePK compraDetallePK;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_compra", referencedColumnName = "id_compra", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Compra compra;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Producto producto;

	@Column
	private int cant_existente;
	private int cant_autorizada;
	private int cant_comprada;
	private float precio_unitario;
	private float precio_total;

	public CompraDetallePK getCompraDetallePK() {
		return compraDetallePK;
	}

	public void setCompraDetallePK(CompraDetallePK compraDetallePK) {
		this.compraDetallePK = compraDetallePK;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCant_existente() {
		return cant_existente;
	}

	public void setCant_existente(int cant_existente) {
		this.cant_existente = cant_existente;
	}

	public int getCant_autorizada() {
		return cant_autorizada;
	}

	public void setCant_autorizada(int cant_autorizada) {
		this.cant_autorizada = cant_autorizada;
	}

	public int getCant_comprada() {
		return cant_comprada;
	}

	public void setCant_comprada(int cant_comprada) {
		this.cant_comprada = cant_comprada;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	private static final long serialVersionUID = 1L;

}
