package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventarioDetallePK implements Serializable{
	@Column(name = "id_inventario", nullable = false)
	private long idInventario;

	@Column(name = "id_producto", nullable = false)
	private long idProducto;

	public long getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(long idInventario) {
		this.idInventario = idInventario;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	
	
	private static final long serialVersionUID = 1L;
}
