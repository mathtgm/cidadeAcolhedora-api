package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Error.AnimalNotFound;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	
	// Procura animais pelo nome
	public List<Animal> findByNome(String nome, Long id_doador) {
		Optional<List<Animal>> optValue = animalRepository.findByNome(nome, id_doador);
		
		optValue.orElseThrow(() -> new AnimalNotFound("nome", nome));
		
		
		return optValue.get();
	}
	
	// Procura animais pelo ID
	public Animal findById(Long id_animal) {
		Optional<Animal> optValue = animalRepository.findById(id_animal);
		
		optValue.orElseThrow(() -> new AnimalNotFound("identificação",id_animal.toString()));
		
		return optValue.get();
		
	}
	
	// Lista todos o animais cadastrados
	public List<Animal> listAnimals() {
		
		List<Animal> listaAnimais = (List<Animal>) animalRepository.findAll();
		
		if(listaAnimais.isEmpty())
			throw new AnimalNotFound();
		
		return listaAnimais;
	
	}
	
	// Lista o tipo de animais (Gato, Cachorro e etc)
	public List<Animal> findByTipo(String tipo) {
		
		Optional<List<Animal>> optValue = animalRepository.findByTipo(tipo); 
		
		optValue.orElseThrow(() -> new AnimalNotFound("tipo", tipo));
		
		return optValue.get();
		
	}
	
	// Lista os animais da cidade
	public List<Animal> findByCidade(Integer id) {
		
		Optional<List<Animal>> optValue = animalRepository.findByCidade(id);
		
		optValue.orElseThrow(() -> new AnimalNotFound("cidade", id.toString()));
		
		
		return optValue.get();
	}
	
	// Lista os animais do estado
	public List<Animal> findByEstado(Integer id) {
		
		Optional<List<Animal>> optValue = animalRepository.findByEstado(id);
		
		optValue.orElseThrow(() -> new AnimalNotFound("estado", id.toString()));
		
		return optValue.get();
	}
	
	// Lista os animais do doador
	public List<Animal> findAnimalById_doador(Long id_doador) {
		
		Optional<List<Animal>> optValue = animalRepository.findById_doador(id_doador);
		
		optValue.orElseThrow(() -> new AnimalNotFound());
		
		return optValue.get();
		
	}
	
	// Lista os animais do tutor
	public List<Animal> findAnimalById_tutor(Long id_tutor) {
		
		Optional<List<Animal>> optValue = animalRepository.findById_tutor(id_tutor);
		
		optValue.orElseThrow(() -> new AnimalNotFound());
		
		return optValue.get();
		
	}
	
	// Salva o animal no banco de dados
	public Animal saveAnimal(Animal animal) {
		
		return animalRepository.save(animal);
		
	}
	
	// Exclui Animal do banco de dados
	public void deleteAnimal(Long id_animal) {
		
		animalRepository.deleteById(id_animal);
		
	}
	
	// Atualizar dados do animal
	public Animal updateAnimal(Animal animal) {
		
		return animalRepository.save(animal);
	}
}
