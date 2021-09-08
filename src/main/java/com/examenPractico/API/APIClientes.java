package com.examenPractico.API;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenPractico.Inerfaces.IClientes;
import com.examenPractico.model.Clientes;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/NutriNET")
public class APIClientes {
	@Autowired (required = true)
	IClientes iclient;
	@GetMapping("/Cliente")
	public ResponseEntity<List<Clientes>> getAllPersonas(){
		try {
			List<Clientes> cliente = new ArrayList<Clientes>();
			iclient.findAll().forEach(cliente::add);
			if(cliente.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/Cliente/{id}")
	public ResponseEntity<Clientes> getAllPersonas(@PathVariable("id")long id){
		Optional<Clientes> clienteData = iclient.findById(id);
		if(clienteData.isPresent()){
			return new ResponseEntity<>(clienteData.get(),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<Clientes> createPersona(@RequestBody Clientes cliente){
		try {
			Clientes _cliente= iclient.save(new Clientes(
					cliente.getNombre_Usuario()
				   ,cliente.getContrasena()
				   ,cliente.getNombre()
				   ,cliente.getApellidos()
				   ,cliente.getCorreo_Electronico()
				));
			return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/Cliente/{id}")
	public ResponseEntity<Clientes> updatePersona(@PathVariable("id")long id, @RequestBody Clientes cliente){
		Optional<Clientes>clienteData=iclient.findById(id);
		if (clienteData.isPresent()) {
			Clientes _cliente = clienteData.get();
			_cliente.setNombre_Usuario(cliente.getNombre_Usuario());
			_cliente.setContrasena(cliente.getContrasena());
			_cliente.setNombre(cliente.getNombre());
			_cliente.setApellidos(cliente.getApellidos());
			_cliente.setCorreo_Electronico(cliente.getCorreo_Electronico());
			return new ResponseEntity<>(iclient.save(_cliente),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePersona(@PathVariable("id")long id){
		try {
			iclient.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {  
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
