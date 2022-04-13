package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle_compra_PFDC")
public class detalle_compra_PFDC implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle_compra_PFDC;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Compra compra;

	private String nombreProducto;

	@Column
	private int cant_existente;
	private int cant_solicitada;	
	private int cant_autorizada;
	private int cant_comprada;
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
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

	public int getCant_comprada() {
		return cant_comprada;
	}

	public void setCant_comprada(int cant_comprada) {
		this.cant_comprada = cant_comprada;
	}

	public Long getId_detalle_compra_PFDC() {
		return id_detalle_compra_PFDC;
	}

	public void setId_detalle_compra_PFDC(Long id_detalle_compra_PFDC) {
		this.id_detalle_compra_PFDC = id_detalle_compra_PFDC;
	}


	private static final long serialVersionUID = 1L;

}
