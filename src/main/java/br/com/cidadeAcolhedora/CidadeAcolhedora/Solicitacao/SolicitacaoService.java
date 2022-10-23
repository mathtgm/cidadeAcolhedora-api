package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoService {
	
	@Autowired
	public SolicitacaoRepository solicitacaoRepository;
	
	// Encontrar todas as solicitacoes do Animal
	public List<Solicitacao> findByIdAnimal(Long id_animal) {
		
		List<Solicitacao> listSolicitacao = solicitacaoRepository.findByIdAnimal(id_animal);
		
		return listSolicitacao;
		
	}
	
	// Encontrar todas as solicitacoes do adotante
	public List<Solicitacao> findByIdAdotante(Long id_adotante) {
		
		List<Solicitacao> listSolicitacao = solicitacaoRepository.findByIdAdotante(id_adotante);
		
		return listSolicitacao;
		
	}
	
	// Econtrar solicitacao por ID
	public Solicitacao findById(Long id_solicitacao) {
		
		Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(id_solicitacao);
		
		return solicitacao.get();
		
	}
	
	
}
