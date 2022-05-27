package com.sofipa.proyecto.papeleria.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.proyecto.papeleria.models.entity.Solicitud;
import com.sofipa.proyecto.papeleria.models.services.ISolicitudService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SolicitudRestController {
	@Autowired
	private ISolicitudService solicitudService;
	
	//Método que devuelve todos las solicitudes de la base de datos
	@GetMapping("/solicitudes")
	public List<Solicitud> index() {
		return solicitudService.findAll();
	}
	
	//Método que devuelve todas las solicitudes de una determinada sucursal
	@GetMapping("/solicitudes/sucursal/{id}")
	public List <Solicitud> showSS(@PathVariable Long id)
	{
		return solicitudService.findBySucursal(id);
	}
	
	//Método que devuelve una solicitud mediante su identificador(id_solicitud)
	@GetMapping("/solicitudes/{id}")
	public Solicitud show(@PathVariable Long id) {
		return solicitudService.findById(id);
	}
	
	//Método para crear una nueva Solicitud
	@PostMapping("/solicitudes")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitud create(@RequestBody Solicitud solicitud) {
		return solicitudService.save(solicitud);
	}
	
	//Método para actualizar una nueva solicitud
	@PutMapping("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitud update(@RequestBody Solicitud solicitud, @PathVariable Long id) {
		//Se busca la solicitud a actualizar en la base de datos
		Solicitud solicitudActual = solicitudService.findById(id);
		//Se realizan los posibles cambios
		solicitudActual.setUsuario_aprob(solicitud.getUsuario_aprob());
		solicitudActual.setId_sucursal(solicitud.getId_sucursal());
		solicitudActual.setNombre_sucursal(solicitud.getNombre_sucursal());
		solicitudActual.setNombre_usuario(solicitud.getNombre_usuario());
		solicitudActual.setFecha_solicitud(solicitud.getFecha_solicitud());
		solicitudActual.setFecha_rechazo(solicitud.getFecha_rechazo());
		solicitudActual.setFecha_aprobacion(solicitud.getFecha_aprobacon());
		solicitudActual.setFecha_abastecimiento(solicitud.getFecha_abastecimiento());
		solicitudActual.setFecha_cancelacion(solicitud.getFecha_cancelacion());
		solicitudActual.setObservacion_solicitud(solicitud.getObservacion_solicitud());
		solicitudActual.setObservacion_aprobacion_rechazo(solicitud.getObservacion_aprobacion_rechazo());
		solicitudActual.setPfdc(solicitud.isPfdc());
		solicitudActual.setEstatus(solicitud.getEstatus());
		//Y se actualiza la solicitud
		return solicitudService.save(solicitudActual);
	}
}
