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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class SolicitudRestController {
	@Autowired
	private ISolicitudService solicitudService;
	
	@GetMapping("/solicitudes")
	public List<Solicitud> index()
	{
		return solicitudService.findAll();
	}
	
	@GetMapping("/solicitudes/{id}")
	public Solicitud show(@PathVariable Long id)
	{
		return solicitudService.findById(id);
	}
	
	@PostMapping("/solicitudes")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitud create (@RequestBody Solicitud solicitud)
	{
		return solicitudService.save(solicitud);
	}
	
	@PutMapping("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitud update(@RequestBody Solicitud solicitud, @PathVariable Long id)
	{
		Solicitud solicitudActual = solicitudService.findById(id);
		solicitudActual.setId_usuario_aprob(solicitud.getId_usuario_aprob());
		solicitudActual.setId_sucursal(solicitud.getId_sucursal());
		solicitudActual.setNombre_usuario(solicitud.getNombre_usuario());
		solicitudActual.setFecha_solicitud(solicitud.getFecha_solicitud());
		solicitudActual.setFecha_rechazo(solicitud.getFecha_rechazo());
		solicitudActual.setFecha_aprobacion(solicitud.getFecha_aprobacon());
		solicitudActual.setFecha_abastecimiento(solicitud.getFecha_abastecimiento());
		solicitudActual.setFecha_cancelacion(solicitud.getFecha_cancelacion());
		solicitudActual.setObservacion_solicitud(solicitud.getObservacion_solicitud());
		solicitudActual.setObservacion_aprobacion_rechazo(solicitud.getObservacion_aprobacion_rechazo());
		solicitudActual.setEstatus(solicitud.getEstatus());
		
		return solicitudService.save(solicitudActual);
	}
	

}
