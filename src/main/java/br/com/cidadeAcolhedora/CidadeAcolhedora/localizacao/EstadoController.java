package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping("/")
	public ResponseEntity<List<Estado>> findAllEstados() {
		
		return ResponseEntity.ok(estadoService.listaAllEstados());
		
	}
	
	@RequestMapping("/{id_estado}")
	public ResponseEntity<Estado>findEstadoById(@PathVariable Long id_estado) {
		
		return ResponseEntity.ok(estadoService.findEstadoById(id_estado));
		
	}
}
