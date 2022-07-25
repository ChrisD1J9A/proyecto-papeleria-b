package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SolicitudDetallePK implements Serializable {
	/*
	 *La clase SolicitudDetallePK (Auxiliar en el mapeo de Detalle_solicitud, Solicitud y Producto)
	 * */

	@Column(name = "id_solicitud", nullable = false)
	private long idSolicitud;

	@Column(name = "id_producto", nullable = false)
	private long idProducto;

	public long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	private static final long serialVersionUID = 1L;

}
