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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_solicitud;
	
	@Column
	private Long id_usuario_aprob;
	private Long id_sucursal;
	private String nombre_usuario;
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
	private String estatus;
	
	public Long getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Long id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Long getId_usuario_aprob() {
		return id_usuario_aprob;
	}

	public void setId_usuario_aprob(Long id_usuario_aprob) {
		this.id_usuario_aprob = id_usuario_aprob;
	}

	public Long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	/**@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudes")
	private Collection<detalle_solicitud> solicitudDetalleCollection = new ArrayList<detalle_solicitud>();
	
	public void agregarDetalle(detalle_solicitud det, Producto producto) {
	      this.solicitudDetalleCollection.add(det);
	      det.setSolicitudDetallePK(new SolicitudDetallePK(this.id_solicitud, producto.getId_producto()));
	 }**/

	private static final long serialVersionUID = 1L;
	
}
