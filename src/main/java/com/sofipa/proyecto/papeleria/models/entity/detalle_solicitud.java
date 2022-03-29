package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle_solicitud")
public class detalle_solicitud implements Serializable {
	@EmbeddedId
	private SolicitudDetallePK solicitudDetallePK;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Solicitud solicitud;

	@ManyToOne(optional= true, fetch= FetchType.EAGER)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Producto producto;

	@Column
	private int cant_existente;
	private int cant_solicitada;	
	private int cant_autorizada;

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
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

	public int getCant_solicitada() {
		return cant_solicitada;
	}

	public void setCant_solicitada(int cant_solicitada) {
		this.cant_solicitada = cant_solicitada;
	}

	public int getCant_autorizada() {
		return cant_autorizada;
	}

	public void setCant_autorizada(int cant_autorizada) {
		this.cant_autorizada = cant_autorizada;
	}
	
	public SolicitudDetallePK getSolicitudDetallePK() {
		return solicitudDetallePK;
	}

	public void setSolicitudDetallePK(SolicitudDetallePK solicitudDetallePK) {
		this.solicitudDetallePK = solicitudDetallePK;
	}

	private static final long serialVersionUID = 1L;

}
