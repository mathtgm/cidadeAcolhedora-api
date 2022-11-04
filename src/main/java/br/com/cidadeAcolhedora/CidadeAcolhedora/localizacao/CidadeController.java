package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping("/")
	public ResponseEntity<List<Cidade>> findAllCidades() {
		
		return ResponseEntity.ok(cidadeService.getAllCidades());
		
	}
	
	@RequestMapping("/estado/{id_estado}")
	public ResponseEntity<List<Cidade>> findCidadeByEstadoId(@PathVariable Long id_estado) {
		
		return ResponseEntity.ok(cidadeService.getCidadeByEstadoId(id_estado));
		
	}
}
