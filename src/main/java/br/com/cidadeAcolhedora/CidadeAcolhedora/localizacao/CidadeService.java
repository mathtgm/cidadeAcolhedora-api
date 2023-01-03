package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
	
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> getAllCidades() {
		
		return (List<Cidade>)cidadeRepository.findAll();
		
	}
	
	public List<Cidade> getCidadeByEstadoId(Long id_estado) {
		
		return cidadeRepository.findEstadoById(id_estado);
	}
	
	public Cidade getCidadeById(Long id_cidade) {
		
		return cidadeRepository.findById(id_cidade).get();
		
	}
}
