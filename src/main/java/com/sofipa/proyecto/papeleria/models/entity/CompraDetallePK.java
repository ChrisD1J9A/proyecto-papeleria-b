package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompraDetallePK implements Serializable {
	@Column(name = "id_compra", nullable = false)
	private long idCompra;

	@Column(name = "id_producto", nullable = false)
	private long idProducto;

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	private static final long serialVersionUID = 1L;
}
