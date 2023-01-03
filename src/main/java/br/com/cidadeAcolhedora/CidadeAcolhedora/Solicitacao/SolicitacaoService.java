package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.AnimalRepository;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Usuario;

@Service
public class SolicitacaoService {
	
	@Autowired
	public SolicitacaoRepository solicitacaoRepository;
	
	@Autowired
	public AnimalRepository animalRepository;
	
	// Encontrar todas as solicitacoes do Animal
	public List<Solicitacao> findByIdAnimal(Long id_animal) {

		Animal animal = new Animal();
		animal.setId_animal(id_animal);
		List<Solicitacao> listSolicitacao = solicitacaoRepository.findById_Animal(animal);
		
		return listSolicitacao;
		
	}
	
	// Encontrar todas as solicitacoes do adotante
	public List<Solicitacao> findByIdAdotante(Long id_adotante) {
		
		Usuario user = new Usuario();
		user.setId_usuario(id_adotante);
		List<Solicitacao> listSolicitacao = solicitacaoRepository.findById_Adotante(user);
		
		return listSolicitacao;
		
	}
	
	// Econtrar solicitacao por ID
	public Solicitacao findById(Long id_solicitacao) {
		
		Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(id_solicitacao);
		
		return solicitacao.get();
		
	}
	
	// Encontra as 5 ultimas solicitacoes do Animal
	public List<Solicitacao> findByIdAnimalLimite(Long id_animal) {

		Animal animal = new Animal();
		animal.setId_animal(id_animal);
		List<Solicitacao> listSolicitacao = solicitacaoRepository.findById_AnimalLimite(animal);
			
		return listSolicitacao;
			
	}

	// Encontra as 5 ultimas solicitacoes do Adotante
	public List<Solicitacao> findByIdAdotanteLimite(Long id_adotante) {

		Usuario usuario = new Usuario();
		usuario.setId_usuario(id_adotante);
		List<Solicitacao> listSolicitacao = solicitacaoRepository.findById_AdotanteLimite(usuario);
				
		return listSolicitacao;
				
	}
	
	public Solicitacao cadastrarSolicitacao(Solicitacao solicitacao) {
		
		Solicitacao temSolicitacao = solicitacaoRepository.findByIdAnimalAndIdAdotante(solicitacao.getId_animal().getId_animal(), solicitacao.getId_adotante().getId_usuario());
		
		if(temSolicitacao == null) {
			solicitacao.setData_solicitacao(LocalDateTime.now());
			solicitacao.setSituacao('A');
			
			return solicitacaoRepository.save(solicitacao);
		} else {
			return new Solicitacao();
		}
		
	}
	
	public Solicitacao alterarStatus(Solicitacao solicitacao) {
		
		Animal animal = new Animal();
		
		if(solicitacao.getSituacao() == 'D') {
			
			List<Solicitacao> listaSolicitacao = new ArrayList<Solicitacao>();
			
			listaSolicitacao = solicitacaoRepository.findById_Animal(solicitacao.getId_animal());
			
			for (Solicitacao elemento : listaSolicitacao) {
				if(elemento.getId_solicitacao() != solicitacao.getId_solicitacao()) {
					elemento.setSituacao('C');
				}
			}
			
			solicitacaoRepository.saveAll(listaSolicitacao);
			
			animal = animalRepository.findById(solicitacao.getId_animal().getId_animal()).get();
			animal.setIdTutor(solicitacao.getId_adotante());
			
			animalRepository.save(animal);
			
		}
		
		return solicitacaoRepository.save(solicitacao);
		
	}
	
	public List<Solicitacao> findByIdDoador(Long id_doador) {
		
		return solicitacaoRepository.findByIdDoador(id_doador);
		
	}
	
}
