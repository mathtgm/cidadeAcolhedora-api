package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.cidadeAcolhedora.CidadeAcolhedora.ResponseDefault.ResponseDefault;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	/*
	 * private final String pathArquivos;
	 * 
	 * public AnimalController(@Value("${app.path.imagens}") String pathArquivos) {
	 * this.pathArquivos = pathArquivos; }
	 * 
	 * @PostMapping("/imagem") public ResponseEntity<String>
	 * salvarImagem(@RequestParam("image") MultipartFile image){ String formato =
	 * FilenameUtils.getExtension(image.getOriginalFilename()); String novoCaminho =
	 * pathArquivos + UUID.randomUUID() + formato;
	 * 
	 * try { Files.copy(image.getInputStream(), Path.of(novoCaminho),
	 * StandardCopyOption.REPLACE_EXISTING); return new
	 * ResponseEntity<String>(HttpStatus.OK); } catch (Exception e) { return new
	 * ResponseEntity<String>(HttpStatus.SEE_OTHER); } }
	 */
	
	// ###### Metodos GET ######
	
	@RequestMapping("/nome/{nome}")
	public List<Animal> findByName(@PathVariable String nome) {		
		
		return animalService.findByNome(nome);
	
	}
	
	@RequestMapping("/{id}")
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
	
	// ###### Metodos POST ######
	
	@PostMapping(path = "/cadastrar/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Animal saveAnimal(@RequestBody Animal animal) {
		
		return animalService.saveAnimal(animal);
		
	}
	
	// ###### Metodos PUT ######
	
	@PutMapping(path = "/atualizar/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Animal updateAnimal(@RequestBody Animal animal) {
		
		return animalService.updateAnimal(animal);
		
	}
	
	// ###### Metodo DELETE ######
	
	@DeleteMapping("/remover/{id_animal}")
	public ResponseEntity<ResponseDefault> deleteAnimal(@PathVariable Long id_animal) {
		
		ResponseDefault res = new ResponseDefault();
		res.setStatusCode(HttpStatus.OK);
		res.setMessage("Animal com a ID: " + id_animal + " removido com sucesso!");
		
		return ResponseEntity.status(HttpStatus.OK).body(res);
		
	}

 }