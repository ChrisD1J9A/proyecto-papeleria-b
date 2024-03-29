package com.sofipa.proyecto.papeleria.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable{
	/**
	 * La entidad solicitud es la representación de información que se necesita, 
	 * se asocia a la tabla de la base de datos el nombre solicitudes.
	 * Se muestra la entidad Solicitud, así como sus respectivos atributos 
	 * mismos que son las columnas de la tabla que representa en la base de datos, 
	 * los correspondientes métodos get y set. 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_solicitud;
	
	@Column
	private String usuario_aprob;
	@Column(name="idSucursal")
	private Long idSucursal;
	private String nombre_usuario; 
	private String correo_solicitante;
	private String nombre_sucursal;
	@Column(name="fecha_solicitud")
	@Temporal(TemporalType.DATE) 
	private Date fecha_solicitud;
	
	@Column(name="fecha_rechazo")
	@Temporal(TemporalType.DATE)
	private Date fecha_rechazo;
	
	@Column(name="fecha_aprobacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_aprobacion;
	
	@Column(name="fecha_abastecimiento")
	@Temporal(TemporalType.DATE)
	private Date fecha_abastecimiento;
	
	@Column(name="fecha_cancelacion")
	@Temporal(TemporalType.DATE)
	private Date fecha_cancelacion;
	private String observacion_solicitud;
	private String observacion_aprobacion_rechazo;
	private boolean pfdc;
	private String estatus;
	
	public Long getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Long id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public String getUsuario_aprob() {
		return usuario_aprob;
	}

	public void setUsuario_aprob(String usuario_aprob) {
		this.usuario_aprob = usuario_aprob;
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

	public Date getFecha_aprobacion() {
		return fecha_aprobacion;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo_solicitante() {
		return correo_solicitante;
	}

	public void setCorreo_solicitante(String correo_solicitante) {
		this.correo_solicitante = correo_solicitante;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public Date getFecha_rechazo() {
		return fecha_rechazo;
	}

	public void setFecha_rechazo(Date fecha_rechazo) {
		this.fecha_rechazo = fecha_rechazo;
	}

	public Date getFecha_aprobacon() {
		return fecha_aprobacion;
	}

	public void setFecha_aprobacion(Date fecha_aprobacion) {
		this.fecha_aprobacion = fecha_aprobacion;
	}

	public Date getFecha_abastecimiento() {
		return fecha_abastecimiento;
	}

	public void setFecha_abastecimiento(Date fecha_abastecimiento) {
		this.fecha_abastecimiento = fecha_abastecimiento;
	}

	public Date getFecha_cancelacion() {
		return fecha_cancelacion;
	}

	public void setFecha_cancelacion(Date fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}

	public String getObservacion_solicitud() {
		return observacion_solicitud;
	}

	public void setObservacion_solicitud(String observacion_solicitud) {
		this.observacion_solicitud = observacion_solicitud;
	}

	public String getObservacion_aprobacion_rechazo() {
		return observacion_aprobacion_rechazo;
	}

	public void setObservacion_aprobacion_rechazo(String observacion_aprobacion_rechazo) {
		this.observacion_aprobacion_rechazo = observacion_aprobacion_rechazo;
	}
	
	public boolean isPfdc() {
		return pfdc;
	}

	public void setPfdc(boolean pfdc) {
		this.pfdc = pfdc;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	private static final long serialVersionUID = 1L;
	
}
