package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
		
	// ###### Metodos GET ######
	
	@RequestMapping("/nome/{id_doador}/{nome}")
	public List<Animal> findByName(@PathVariable String nome, @PathVariable Long id_doador) {		
		
		return animalService.findByNome(nome, id_doador);
	
	}
	
	@RequestMapping("/id/{id}")
	public Animal findById(@PathVariable Long id) {
		
		return animalService.findById(id);
	
	}
	
	@RequestMapping("/tipo/{tipo}")
	public List<Animal> findByTipo(@PathVariable String tipo) {
		
		return animalService.findByTipo(tipo);
	
	}
	
	@RequestMapping("/todos")
	public List<Animal> findAllAnimal() {
		
		return animalService.listAnimals();
		
	}
	
	@RequestMapping("/cidade/{id_cidade}")
	public List<Animal> findAnimalByCidade(@PathVariable Integer id_cidade) {
			
		return animalService.findByCidade(id_cidade);
		
	}
	
	@RequestMapping("/estado/{id_estado}")
	public List<Animal> findAnimalByEstado(@PathVariable Integer id_estado) {
		
		return animalService.findByEstado(id_estado);
		
	}
	
	@RequestMapping("/tutor/{id_tutor}")
	public List<Animal> findByIdTutor(@PathVariable Long id_tutor) {
		
		return animalService.findAnimalById_tutor(id_tutor);
		
	}
	
	@RequestMapping("/doador/{id_doador}")
	public List<Animal> findById_doador(@PathVariable Long id_doador) {
		
		return animalService.findAnimalById_doador(id_doador);
		
	}
	
	// ###### Metodos POST ######
	
	@PostMapping(path = "/cadastrar/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Animal> saveAnimal(@RequestBody Animal animal) {

		return ResponseEntity.ok().body(animalService.saveAnimal(animal));
		
	}
	
	// ###### Metodos PUT ######
	
	@PutMapping(path = "/atualizar/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Animal updateAnimal(@RequestBody Animal animal) {
		
		return animalService.updateAnimal(animal);
		
	}
	
	// ###### Metodo DELETE ######
	
	@DeleteMapping("/remover/{id_animal}")
	public ResponseEntity<Animal> deleteAnimal(@PathVariable Long id_animal) {
		
		try {
			
			Animal animal = animalService.findById(id_animal);
			animalService.deleteAnimal(id_animal);
			
			return ResponseEntity.ok().body(animal);
			
		} catch (EmptyResultDataAccessException err) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Animal());
			
		}
		
		
	}

 }
