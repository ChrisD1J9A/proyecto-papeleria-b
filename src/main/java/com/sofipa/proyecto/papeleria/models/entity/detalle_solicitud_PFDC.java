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
@Table(name="detalle_solicitud_PFDC")
public class detalle_solicitud_PFDC implements Serializable {
	@EmbeddedId
	private SolicitudPFDCDetallePK solicitudPFDCDetallePK;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Solicitud solicitud;

	private String nombreProducto;

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
	
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
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
	
	public SolicitudPFDCDetallePK getSolicitudPFDCDetallePK() {
		return solicitudPFDCDetallePK;
	}

	public void setSolicitudPFDCDetallePK(SolicitudPFDCDetallePK solicitudPFDCDetallePK) {
		this.solicitudPFDCDetallePK = solicitudPFDCDetallePK;
	}


	private static final long serialVersionUID = 1L;

}
