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
import com.sofipa.proyecto.papeleria.models.entity.CompraDetallePK;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra;
import com.sofipa.proyecto.papeleria.models.services.IDetalleCompraService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DetalleCompraRestController {
	@Autowired
	private IDetalleCompraService detalleCompraService;
	
	//Método para crear, almacenar un detalle 
	@PostMapping("/detalle_compra")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_compra create (@RequestBody detalle_compra dc)
	{
		//Para una entidad cuya Primary key se compone de dos 
		//Id_compra e Id_producto, se asigna al objeto mediante el compraDetallePK para definirse
		CompraDetallePK compraDetallePk = new CompraDetallePK();
		compraDetallePk.setIdCompra(dc.getCompra().getId_compra());
		compraDetallePk.setIdProducto(dc.getProducto().getId_producto());
		dc.setCompraDetallePK(compraDetallePk);//Se asigna al detalle compra su PK antes de guardar
		return detalleCompraService.save(dc);//Se guarda y devuelve el objeto creado
	}
	
	//Método utilizado para realizar un UPDATE de un grupo de detalles de compra
	@PutMapping("/detalle_compra/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_compra> update(@RequestBody detalle_compra[] detalles_f, @PathVariable Long id)
	{
		detalle_compra detaActual = new detalle_compra();
		for(int i =  0; i < detalles_f.length; i++)//Se hace un ciclo for recorriendo todo el arreglo
		{
			detaActual = detalles_f[i];//Cada miembro del arreglo se va asignando al objeto anteriormente creado
			detalleCompraService.save(detaActual);//Se actualiza en la base de datos
		}
		
		return detalleCompraService.detalles_de_compra(id);//Se devuelven los detalles actualizados
		
	}
	
	//Método para obtener todos los detalles de compra mediante el id_compra
	@GetMapping("/detalle_compra/{id}")
	public List<detalle_compra> detalles_de_comp(@PathVariable Long id)
	{
		return detalleCompraService.detalles_de_compra(id);
	}
}
