package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Usuario;

@Service
public class SolicitacaoService {
	
	@Autowired
	public SolicitacaoRepository solicitacaoRepository;
	
	// Encontrar todas as solicitacoes do Animal
	public List<Solicitacao> findByIdAnimal(Long id_animal) {
		
		System.out.println("Cheguei no Service " + id_animal );
		
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
	
	
}
