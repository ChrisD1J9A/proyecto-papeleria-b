package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "compras")
public class Compra implements Serializable{
	/*
	 * La entidad compra es la representación de información que se necesita, 
	 * se asocia a la tabla de la base de datos el nombre compras, 
	 * mantiene una relación OneToOne con la tabla solicitudes y otra relación ManyToOne con la tabla proveedores.
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra; 
	
	@OneToOne(optional= false, fetch= FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Solicitud solicitud;
	
	@ManyToOne(optional= true, fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedor;
	
	@Column(name="idSucursal")
	private Long idSucursal;
	
	@Column(name="nombre_sucursal")
	private String nombre_sucursal;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	@Column(name="gasto_total")
	private float gasto_total;
	
	@Column(name="ticket")
	private String ticket;
	
	@Column(name="observaciones")
	private String observaciones;
	
	@Column(name="estatus")
	private String estatus;
	
	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public float getGasto_total() {
		return gasto_total;
	}

	public void setGasto_total(float gasto_total) {
		this.gasto_total = gasto_total;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	private static final long serialVersionUID = 1L;
}
