package persona;

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

import model.Persona;
import repository.IPersona;


@RestController
@RequestMapping("/Persona")

public class ApiPersona {
	@Autowired(required=true)
	IPersona InterfazPersona;
	@CrossOrigin(origins ="*")
	@GetMapping
	public ResponseEntity<List<Persona>> getAllPersona(){
		try {
			List<Persona> persona = new ArrayList<Persona>();
			InterfazPersona.findAll().forEach(persona::add);
			if(persona.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(persona, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@CrossOrigin(origins ="*")
	@GetMapping("/{id}")
	public ResponseEntity<Persona> getAllPersona(@PathVariable("id")long id){
		Optional<Persona> personaData = InterfazPersona.findById(id);
		if(personaData.isPresent()){
		return new ResponseEntity<>(personaData.get(),HttpStatus.OK);
		}
		else{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	}
	@CrossOrigin(origins ="*")
	@PostMapping
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
		try {
			Persona _persona= InterfazPersona.save( new Persona(
					persona.getNombre()
				   ,persona.getAp_Pat()
				   ,persona.getAp_Mat()
					,persona.getEdad()
					,persona.getPeso()
					,persona.getEstatura()
					,persona.getEstado_civil()
				));
			
		return new ResponseEntity<>(_persona, HttpStatus.CREATED);
	}
		catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@CrossOrigin(origins ="*")
	@PutMapping("/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable("id")long id, @RequestBody Persona persona){
		Optional<Persona>personaData=InterfazPersona.findById(id);
		if (personaData.isPresent()) {
			Persona _persona = personaData.get();
			
			_persona.setNombre(persona.getNombre());
			_persona.setAp_Pat(persona.getAp_Pat());
			_persona.setAp_Mat(persona.getAp_Mat());
			_persona.setEdad(persona.getEdad());
			_persona.setPeso(persona.getPeso());
			_persona.setEstatura(persona.getEstatura());
			_persona.setEstado_civil(persona.getEstado_civil());
			
		
		return new ResponseEntity<>(InterfazPersona.save(_persona),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
			
	}
	@CrossOrigin(origins ="*")
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePersona(@PathVariable("id")long id){
		try {
			InterfazPersona.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {  
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

}
