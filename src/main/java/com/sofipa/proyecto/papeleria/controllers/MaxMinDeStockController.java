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
import com.sofipa.proyecto.papeleria.models.services.IMaxMinDeStockService;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeStock;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MaxMinDeStockController {
	@Autowired 
	private IMaxMinDeStockService maxMinStockService;
	
	//Método para obtener todas las configuraciones 
	@GetMapping("/maxMinStock")
	public List<MaxMinDeStock> index()
	{
		return maxMinStockService.findAll();
	}
	
	//Método para obtener una configuración mediante su id
	@GetMapping("/maxMinStock/{id}")
	public MaxMinDeStock show(@PathVariable Long id) 
	{
		return maxMinStockService.findById(id);
	}
	
	//Método para obtener la configuración de una determinada sucursal
	@GetMapping("/maxMinStockS/{sucursal}")
	public MaxMinDeStock showBySucursal(@PathVariable String sucursal) 
	{
		return maxMinStockService.findBySucursal(sucursal);
	}
	
	//Método para crear una nueva configuración
	@PostMapping("/maxMinStock")
	@ResponseStatus(HttpStatus.CREATED)
	public MaxMinDeStock create(@RequestBody MaxMinDeStock maxMinDeStock)
	{
		return maxMinStockService.save(maxMinDeStock);
	}
	
	//Método para  actualizar una nueva configuración
	@PutMapping("/maxMinStock/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public MaxMinDeStock update(@RequestBody MaxMinDeStock maxMinDeStock, @PathVariable Long id)
	{ 
		MaxMinDeStock maxMinStockActual = maxMinStockService.findById(id);
		maxMinStockActual.setSucursal(maxMinDeStock.getSucursal());
		maxMinStockActual.setMax_stock(maxMinDeStock.getMax_stock());
		maxMinStockActual.setMin_stock(maxMinDeStock.getMin_stock());
		maxMinStockActual.setUsuario_modifico(maxMinDeStock.getUsuario_modifico());
		maxMinStockActual.setEstatus(maxMinDeStock.getEstatus());
		maxMinStockActual.setFecha_creacion(maxMinDeStock.getFecha_creacion());
		maxMinStockActual.setFecha_actualizacion(maxMinDeStock.getFecha_actualizacion());
		
		return maxMinStockService.save(maxMinStockActual);
	}
}
