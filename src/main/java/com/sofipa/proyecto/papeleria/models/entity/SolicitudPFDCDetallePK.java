package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SolicitudPFDCDetallePK implements Serializable {

	@Column(name = "id_solicitud", nullable = false)
	private long idSolicitud;

	public long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	private static final long serialVersionUID = 1L;

}
