package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado>listaAllEstados() {
		
		return (List<Estado>) estadoRepository.findAll();
		
	}
	
	public Estado findEstadoById(Long id_estado) {
		
		return estadoRepository.findById(id_estado).get();
		
	}
}
