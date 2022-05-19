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
import com.sofipa.proyecto.papeleria.models.entity.SolicitudDetallePK;
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud;
import com.sofipa.proyecto.papeleria.models.services.IDetalleSolicitudService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DetalleSolicitudRestController {
	@Autowired
	private IDetalleSolicitudService detalleSolicitudService;
	
	@PostMapping("/detalle_solicitud")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_solicitud create (@RequestBody detalle_solicitud ds)
	{
		SolicitudDetallePK solicitudDetallePK = new SolicitudDetallePK();
		solicitudDetallePK.setIdSolicitud(ds.getSolicitud().getId_solicitud());
		solicitudDetallePK.setIdProducto(ds.getProducto().getId_producto());
		ds.setSolicitudDetallePK(solicitudDetallePK);
		return detalleSolicitudService.save(ds);
	}
	
	@PutMapping("/detalle_solicitud/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_solicitud> update(@RequestBody detalle_solicitud [] detalles_f, @PathVariable Long id)
	{
		detalle_solicitud detaActual = new detalle_solicitud();
		for(int i=0; i< detalles_f.length; i++)
		{
			detaActual = detalles_f[i];
			detalleSolicitudService.save(detaActual);
		}
		
		return detalleSolicitudService.detalles_de_solicitud(id);
	}	
	
	@GetMapping("/detalle_solicitud/{id}")
	public List<detalle_solicitud> detalles_de_sol(@PathVariable Long id)
	{
		return detalleSolicitudService.detalles_de_solicitud(id);
	}
}
