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
import com.sofipa.proyecto.papeleria.models.entity.detalle_solicitud_pfdc;
import com.sofipa.proyecto.papeleria.models.services.IDetalleSolicitudPFDCService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DetalleSolicitudPFDCRestController {
	@Autowired
	private IDetalleSolicitudPFDCService detalleSolicitudService;
	 
	//Método para crear, almacenar un detalle de solicitud con productos fuera del catalogo 
	@PostMapping("/detalle_solicitud_pfdc")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_solicitud_pfdc create (@RequestBody detalle_solicitud_pfdc ds)
	{
		return detalleSolicitudService.save(ds);
	}
	
	//Método para crear, almacenar un detalle de solicitud con productos fuera del catalogo 
	@PutMapping("/detalle_solicitud_pfdc/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_solicitud_pfdc> update(@RequestBody detalle_solicitud_pfdc [] detalles_f, @PathVariable Long id)
	{
		detalle_solicitud_pfdc detaActual = new detalle_solicitud_pfdc();
		for(int i=0; i< detalles_f.length; i++)//Se hace un ciclo for recorriendo todo el arreglo
		{
			detaActual = detalles_f[i];//Cada miembro del arreglo se va asignando al objeto anteriormente creado
			detalleSolicitudService.save(detaActual);//Se actualiza en la base de datos
		}
		
		return detalleSolicitudService.detalles_de_solicitud_pfdc(id);//Se devuelven los detalles actualizados
	}	
	
	//Método para obtener todos los detalles de solicitud con productos fuera del catalogo mediante el id_compra
	@GetMapping("/detalle_solicitud_pfdc/{id}")
	public List<detalle_solicitud_pfdc> detalles_de_sol(@PathVariable Long id)
	{
		return detalleSolicitudService.detalles_de_solicitud_pfdc(id);
	}
	
	//Método para obtener todos los detalles de solicitud con productos fuera del catalogo
	@GetMapping("/detalle_solicitud_pfdc")
	public List<detalle_solicitud_pfdc> findALL()
	{
		return detalleSolicitudService.findAll();
	}
}
