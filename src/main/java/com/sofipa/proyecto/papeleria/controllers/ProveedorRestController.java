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
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.proyecto.papeleria.models.entity.Proveedor;
import com.sofipa.proyecto.papeleria.models.services.IProveedorService;

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	@Autowired
	private IProveedorService proveedorService;
	
	//Metodo que devuelve todos los proveedores de la base de datos
	@GetMapping("/proveedores")
	public List<Proveedor> index()
	{
		return proveedorService.findAll();
	}
	
	//Metodo que devuelve un proveedor mediante su identificador(id_proveedor)
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<?> show (@PathVariable Long id)
	{
		//Se declara el Objeto Proveedor que almacenará la consulta
		Proveedor proveedor = null;
		Map<String, Object> response = new HashMap<>();
		try {
			//Se busca el proveedor
			proveedor = proveedorService.findById(id);
			//En caso de haber errores, son manejados en el catch
		} catch(DataAccessException dae) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", dae.getMessage().concat(" : ").concat(dae.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//Se válida que el proveedor buscado  exista, de no existir se notifica 
		if (proveedor == null) {
			response.put("mensaje", "El proveedor con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		//En caso de no haber erroes se manda el Proveedor
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}
	
	//Método para crear un nuevo Proveedor
	@PostMapping("/proveedores")
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor)
	{
		//Se declara un objeto de tipo Proveedor para mandar como respuesta
		Proveedor proveedorNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			//Se realiza la inserción en la base de datos 
			proveedorNew = proveedorService.save(proveedor);
		}catch(DataAccessException e){
			//En caso de haber errores se manejan en esta área
			response.put("mensaje", "error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//De no haber errores se manda el Proveedor creado a lado de un mensaje de inserción exitosa
		response.put("mensaje","El proveedor ha sido creado con éxito");
		response.put("proveedor", proveedorNew);
		 
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//Método para actualizar Proveedor de la base de datos
	@PutMapping("/proveedores/{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedor, @PathVariable Long id)
	{
		/*Se declaran dos objetos, uno para guardar el proveedor a actualizar y consultar en la base de datos
		 *mediante el id y el otro para guardar el proveedor una vez actualizado en la base de datos*/ 
		Proveedor proveedorActual = proveedorService.findById(id);
		Proveedor proveedorUpdated = null;
		Map<String, Object> response = new HashMap<>();
		//Se corrobora que el proveedor a actualizar exista en la base de datos, en caso de no existir se notifica
		if (proveedorActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el proveedor con el ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			//Se efectúan los cambios en la base de datos
			proveedorActual.setNombre(proveedor.getNombre());
			proveedorActual.setDireccion(proveedor.getDireccion());
			proveedorActual.setTelefono(proveedor.getTelefono());
			proveedorActual.setRfc(proveedor.getRfc());
			proveedorActual.setEstatus(proveedor.getEstatus());
			proveedorUpdated =  proveedorService.save(proveedorActual);
			//Cualquier error se maneja en el catch
		}catch(DataAccessException e){
			response.put("mensaje", "error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//De no haber errrores se notifica al usuario y se manda el Proveedors actualizado 	
		response.put("mensaje","El proveedor ha sido actualizado con éxito");
		response.put("proveedor", proveedorUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
