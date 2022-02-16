package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import java.util.Date;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra; 
	
	@OneToOne(optional= false, fetch= FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Solicitud solicitud;
	
	@ManyToOne(optional= false, fetch= FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedor;
	
	@Column
	private long usuario;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	
	@Column(name="gasto_total")
	private float gasto_total;
	
	
	@Column(name="ticket")
	private String ticket;
	
	@Column(name="observaciones")
	private String observaciones;
	
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

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
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


	private static final long serialVersionUID = 1L;
}
