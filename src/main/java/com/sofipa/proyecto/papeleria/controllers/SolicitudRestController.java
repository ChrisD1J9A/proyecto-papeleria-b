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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.proyecto.papeleria.models.entity.Solicitud;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;
import com.sofipa.proyecto.papeleria.models.services.IDetalleSolicitudService;
import com.sofipa.proyecto.papeleria.models.services.ISolicitudService;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class SolicitudRestController {
	@Autowired
	private ISolicitudService solicitudService;
	/*@Autowired
	private IDetalleSolicitudService detalleSolicitudService;*/

	@GetMapping("/solicitudes")
	public List<Solicitud> index() {
		return solicitudService.findAll();
	}
	
	@GetMapping("/solicitudes/sucursal/{id}")
	public List <Solicitud> showSS(@PathVariable Long id)
	{
		return solicitudService.findBySucursal(id);
	}

	@GetMapping("/solicitudes/{id}")
	public Solicitud show(@PathVariable Long id) {
		return solicitudService.findById(id);
	}

	@PostMapping("/solicitudes")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitud create(@RequestBody Solicitud solicitud) {
		return solicitudService.save(solicitud);
	}

	/*@PostMapping("/solicitudesDet")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createS(@RequestBody Solicitud solicitud, @RequestParam("detalles") detalle_solicitud detalles[]) {
		Solicitud solicitudNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			solicitudNew = this.solicitudService.save(solicitud);
			response.put("solicitud", solicitudNew);
			for (detalle_solicitud ds : detalles) {
				ds.setSolicitud(solicitud);
				detalleSolicitudService.save(ds);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar la solicitud" + e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}*/
 
	@PutMapping("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitud update(@RequestBody Solicitud solicitud, @PathVariable Long id) {
		Solicitud solicitudActual = solicitudService.findById(id);
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

		return solicitudService.save(solicitudActual);
	}

}
