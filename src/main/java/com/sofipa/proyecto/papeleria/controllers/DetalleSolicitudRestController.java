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

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DetalleSolicitudRestController {
	@Autowired
	private IDetalleSolicitudService detalleSolicitudService;
	
	//Método para crear, almacenar un detalle solicitud
	@PostMapping("/detalle_solicitud")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_solicitud create (@RequestBody detalle_solicitud ds)
	{
		//Para una entidad cuya Primary key se compone de dos 
		//id_solicitud e id_producto, se asigna al objeto mediante el SolicitudDetallePK para definirse
		SolicitudDetallePK solicitudDetallePK = new SolicitudDetallePK();
		solicitudDetallePK.setIdSolicitud(ds.getSolicitud().getId_solicitud());
		solicitudDetallePK.setIdProducto(ds.getProducto().getId_producto());
		ds.setSolicitudDetallePK(solicitudDetallePK);//Se asigna al detalle solicitud su PK antes de guardar
		return detalleSolicitudService.save(ds);//Se guarda y devuelve el objeto creado
	}
	
	//Método utilizado para realizar un UPDATE de un grupo de detalles de solicitud
	@PutMapping("/detalle_solicitud/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_solicitud> update(@RequestBody detalle_solicitud [] detalles_f, @PathVariable Long id)
	{
		detalle_solicitud detaActual = new detalle_solicitud();
		for(int i=0; i< detalles_f.length; i++)//Se hace un ciclo for recorriendo todo el arreglo
		{
			detaActual = detalles_f[i];//Cada miembro del arreglo se va asignando al objeto anteriormente creado
			detalleSolicitudService.save(detaActual);//Se actualiza en la base de datos
		}
		
		return detalleSolicitudService.detalles_de_solicitud(id);//Se devuelven los detalles actualizados
	}	
	
	//Método para obtener todos los detalles de solicitud mediante el id_solicitud
	@GetMapping("/detalle_solicitud/{id}")
	public List<detalle_solicitud> detalles_de_sol(@PathVariable Long id)
	{
		return detalleSolicitudService.detalles_de_solicitud(id);
	}
} 
