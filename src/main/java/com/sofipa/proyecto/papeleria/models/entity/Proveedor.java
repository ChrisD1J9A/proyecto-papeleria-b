package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proveedor;
	
	@Column(nullable = false)
	private String nombre;
	private String direccion;
	private String telefono;
	@Column(nullable = false, unique = true)
	private String rfc;
	private int estatus;
	
	
	public Long getId_proveedor() {
		return id_proveedor;
	}



	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	public int getEstatus() {
		return estatus;
	}



	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}



	private static final long serialVersionUID = 1L;

}
