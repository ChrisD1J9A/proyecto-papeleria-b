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
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_PFDC;
import com.sofipa.proyecto.papeleria.models.services.IDetalleCompraPFDCService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DetalleCompraPFDCRestController {
	@Autowired
	private IDetalleCompraPFDCService detalleCompraService;
	 
	//Método para crear, almacenar un detalle compra con productos fuera del catalogo 
	@PostMapping("/detalle_compra_PFDC")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_compra_PFDC create (@RequestBody detalle_compra_PFDC ds)
	{
		return detalleCompraService.save(ds);
	}
	
	//Método para realizar un UPDATE de un grupo de detalles de compra con productos fuera del catálogo
	@PutMapping("/detalle_compra_PFDC/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_compra_PFDC> update(@RequestBody detalle_compra_PFDC [] detalles_f, @PathVariable Long id)
	{
		detalle_compra_PFDC detaActual = new detalle_compra_PFDC();
		for(int i=0; i< detalles_f.length; i++)//Se hace un ciclo for recorriendo todo el arreglo
		{
			detaActual = detalles_f[i]; //Cada miembro del arreglo se va asignando al objeto anteriormente creado
			detalleCompraService.save(detaActual);//Se actualiza en la base de datos
		}
		
		return detalleCompraService.detalles_de_compra_PFDC(id);//Se devuelven los detalles actualizados
	}	
	
	//Método para obtener todos los detalles de compra con productos fuera del catalogo mediante el id_compra
	@GetMapping("/detalle_compra_PFDC/{id}")
	public List<detalle_compra_PFDC> detalles_de_com(@PathVariable Long id)
	{
		return detalleCompraService.detalles_de_compra_PFDC(id);
	}
}
