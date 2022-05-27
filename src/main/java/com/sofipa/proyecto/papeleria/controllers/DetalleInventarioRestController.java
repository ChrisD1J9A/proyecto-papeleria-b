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
import com.sofipa.proyecto.papeleria.models.entity.detalle_inventario;
import com.sofipa.proyecto.papeleria.models.services.IDetalleInventarioService;
import com.sofipa.proyecto.papeleria.models.entity.InventarioDetallePK;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DetalleInventarioRestController {
	@Autowired
	private IDetalleInventarioService detalleInventarioService;
	
	//Método para crear, almacenar un detalle de inventario 
	@PostMapping("/detalle_inventario")
	@ResponseStatus(HttpStatus.CREATED)
	public detalle_inventario create (@RequestBody detalle_inventario di)
	{
		//Para una entidad cuya Primary key se compone de dos 
		//id_inventario e id_producto, se asigna al objeto mediante el InventarioDetallePK para definirse
		InventarioDetallePK inventarioDetpk = new InventarioDetallePK();
		inventarioDetpk.setIdProducto(di.getProducto().getId_producto());
		inventarioDetpk.setIdInventario(di.getInventario().getId_inventario());
		di.setInventarioDetallePK(inventarioDetpk);//Se asigna al detalle compra su PK antes de guardar
		return detalleInventarioService.save(di);//Se guarda y devuelve el objeto creado
	}
	
	//Método utilizado para realizar un UPDATE de un grupo de detalles de inventario 
	@PutMapping("/detalle_inventario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<detalle_inventario> update(@RequestBody detalle_inventario [] detalles_i, @PathVariable Long id)
	{
		detalle_inventario detaActual = new detalle_inventario();
		for(int i=0; i< detalles_i.length; i++)//Se hace un ciclo for recorriendo todo el arreglo
		{
			detaActual = detalles_i[i];//Cada miembro del arreglo se va asignando al objeto anteriormente creado
			detalleInventarioService.save(detaActual);//Se actualiza en la base de datos
		}
		
		return detalleInventarioService.detalles_de_inventario(id);//Se devuelven los detalles actualizados
	}
		
	//Método para obtener todos los detalles de inventario mediante el id_inventario
	@GetMapping("/detalle_inventario/{id}")
	public List<detalle_inventario> detalles_de_inv(@PathVariable Long id)
	{
		return detalleInventarioService.detalles_de_inventario(id);
	}
	
	//Método para obtener todos los inventarios disponibles con datos en específico y ordenados
	@GetMapping("/detalle_inventario/todos")
	public List<Object> todos_inventarios()
	{
		return detalleInventarioService.todos_los_inventarios_ordenados();
	}
}
