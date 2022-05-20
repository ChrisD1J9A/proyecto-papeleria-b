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
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud_PFDC;
import com.sofipa.proyecto.papeleria.models.services.IDetalleSolicitudPFDCService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DetalleSolicitudPFDCRestController {
	@Autowired
	private IDetalleSolicitudPFDCService detalleSolicitudService;
	 
	//Método para crear, almacenar un detalle de solicitud con productos fuera del catalogo 
	@PostMapping("/detalle_solicitud_PFDC")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_solicitud_PFDC create (@RequestBody detalle_solicitud_PFDC ds)
	{
		return detalleSolicitudService.save(ds);
	}
	
	//Método para crear, almacenar un detalle de solicitud con productos fuera del catalogo 
	@PutMapping("/detalle_solicitud_PFDC/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_solicitud_PFDC> update(@RequestBody detalle_solicitud_PFDC [] detalles_f, @PathVariable Long id)
	{
		detalle_solicitud_PFDC detaActual = new detalle_solicitud_PFDC();
		for(int i=0; i< detalles_f.length; i++)//Se hace un ciclo for recorriendo todo el arreglo
		{
			detaActual = detalles_f[i];//Cada miembro del arreglo se va asignando al objeto anteriormente creado
			detalleSolicitudService.save(detaActual);//Se actualiza en la base de datos
		}
		
		return detalleSolicitudService.detalles_de_solicitud_PFDC(id);//Se devuelven los detalles actualizados
	}	
	
	//Método para obtener todos los detalles de compra con productos fuera del catalogo mediante el id_compra
	@GetMapping("/detalle_solicitud_PFDC/{id}")
	public List<detalle_solicitud_PFDC> detalles_de_sol(@PathVariable Long id)
	{
		return detalleSolicitudService.detalles_de_solicitud_PFDC(id);
	}
	
	//Método para obtener todos los detalles de compra con productos fuera del catalogo
	@GetMapping("/detalle_solicitud_PFDC")
	public List<detalle_solicitud_PFDC> findALL()
	{
		return detalleSolicitudService.findAll();
	}
}
