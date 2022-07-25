package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_inventario")
public class detalle_inventario implements Serializable {
	/*
	 *Se muestra el mapeo de la entidad débil detalle_inventario, sus atributos, 
	 *sus métodos get y set, así como las referencias hacia las tablas Inventario y Producto. 
	 *La entidad Detalle_inventario tiene la clave primaria compuesta por dos campos: 
	 *id_inventario e id_prodcuto. Entonces, se crea la entidad primaria: InventarioDetallePK 
	 * */
	
	@EmbeddedId
	private InventarioDetallePK inventarioDetallePK;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Inventario inventario;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Producto producto;

	@Column(name = "cant_existente")
	private int cant_existente;

	@Column(name = "estatus")
	private String estatus;

	@Column(name = "fecha_ultima_actualizacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_ultima_actualizacion;

	public InventarioDetallePK getInventarioDetallePK() {
		return inventarioDetallePK;
	}

	public void setInventarioDetallePK(InventarioDetallePK inventarioDetallePK) {
		this.inventarioDetallePK = inventarioDetallePK;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_ultima_actualizacion() {
		return fecha_ultima_actualizacion;
	}

	public void setFecha_ultima_actualizacion(Date fecha_ultima_actualizacion) {
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
	}

	private static final long serialVersionUID = 1L;
}
