package com.sofipa.proyecto.papeleria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.proyecto.papeleria.models.entity.Unidad;
import com.sofipa.proyecto.papeleria.models.services.IUnidadService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UnidadRestController {
	@Autowired
	
	private IUnidadService unidadService;
	
	//Metodo para obtener todas las unidades de la base de datos
	@GetMapping("/unidades")
	public List<Unidad> index()
	{
		return unidadService.findAll();
	}
	
	//Método para obtener una Unidad mediante su identificador (id_unidad)
	@GetMapping("/unidades/{id}")
	public ResponseEntity<?> show (@PathVariable Long id)
	{
		Unidad unidad = null; //Objeto que almacenará la consulta
		Map<String, Object> response = new HashMap<>();
		try {
			unidad = unidadService.findById(id); //Se realiza la busqueda en la base de datos
		}catch(DataAccessException e) { //En caso de haber errores se manejan el catch para informar al usuario
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//En caso de que la consulta no retornó nada se notifica que la unidad buscada no existe o no se localizó
		if(unidad == null) {
			response.put("mensaje", "La unidad con el ID: ".concat(id.toString().concat(". No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		//Se retorna la Unidad dentro ResponseEntity en caso de no  haber problema alguno
		return new ResponseEntity<Unidad>(unidad, HttpStatus.OK); 
	}
	
	//Metodo para crear, almacenar una nueva unidad en la base de datos
	@PostMapping("/unidades")
	public ResponseEntity<?> create (@RequestBody Unidad unidad)
	{
		Unidad unidadNueva = null; //Se declara el objeto que almacenará el nuevo elemento
		Map<String, Object> response = new HashMap<>();
		try {
			//Se realiza la inseción en la base de datos
			unidadNueva = unidadService.save(unidad);//El metodo devuelve el elemento insertado
			
			//En el catch se manejan los posibles errores y se notifica al usuario de los mismos
		}catch (DataAccessException e){
			response.put("mensaje", "Error al ingresar la unidad, unidad existente");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//De no haber errores manda la unidad creada y mensaje indicando la operación exitosa
		response.put("mensaje","La unidad ha sido creada con éxito");
		response.put("unidad", unidadNueva);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//Método utilizado para actualizar una unidad
	@PutMapping("/unidades/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Unidad unidad, @PathVariable Long id)
	{
		//Se declaran dos objetos, uno para guardar la unidad a actualizar y consultada en la base de datos
		//mediante el id y el otro para guardar la unidad una vez actualizada en la base de datos 
		Unidad unidadActual = unidadService.findById(id);
		Unidad unidadUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		//Se corrobora que la Unidad a actualizar exista en la base de datos, en caso de no existir se notifica
		if(unidadActual == null){
			response.put("mensaje", "Error: no se pudo editar, la unidad con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			//Se efectúan los cambios en la base de datos
			unidadActual.setDescripcion(unidad.getDescripcion());
			unidadActual.setEstatus(unidad.getEstatus());
			unidadUpdated = unidadService.save(unidadActual);
			//Cualquier error se maneja en el catch
		}catch(DataAccessException e){
			response.put("mensaje", "error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//De no haber errrores se notifica al usuario y se manda la unidad 
		response.put("mensaje","La unidad ha sido actualizado con éxito");
		response.put("unidad", unidadUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
