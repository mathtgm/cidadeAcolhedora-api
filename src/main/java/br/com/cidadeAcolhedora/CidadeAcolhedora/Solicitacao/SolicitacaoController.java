package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

	
	@Autowired
	public SolicitacaoService solicitacaoService;
	
	@RequestMapping("/{id}")
	public Solicitacao findById(@PathVariable Long id) {
		
		return solicitacaoService.findById(id);
	}
	
	@RequestMapping("/adotante/{id_adotante}")
	public List<Solicitacao> findByIdAdotante(@PathVariable Long id_adotante) {
		
		return solicitacaoService.findByIdAdotante(id_adotante);
		
	}
	
	@RequestMapping("/adotante/limite/{id_adotante}")
	public List<Solicitacao> findByIdAdotanteLimite(@PathVariable Long id_adotante) {
		
		return solicitacaoService.findByIdAdotanteLimite(id_adotante);
		
	}
	
	@RequestMapping("/animal/{id_animal}")
	public List<Solicitacao> findByIdAnimal(@PathVariable Long id_animal) {
		
		return solicitacaoService.findByIdAnimal(id_animal);
		
	}
	
	@RequestMapping("/animal/limite/{id_animal}")
	public List<Solicitacao> findByIdAnimalLimite(@PathVariable Long id_animal) {
		
		return solicitacaoService.findByIdAnimalLimite(id_animal);
		
	}
	
	@RequestMapping("/doador/{id_doador}")
	public ResponseEntity<List<Solicitacao>> findByIdDoador(@PathVariable Long id_doador) {
		
		return ResponseEntity.ok(solicitacaoService.findByIdDoador(id_doador));
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Solicitacao> cadastrarSolicitacao(@RequestBody Solicitacao solicitacao) {
		
		return ResponseEntity.ok(solicitacaoService.cadastrarSolicitacao(solicitacao));			
		
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Solicitacao> atualizarStatus(@RequestBody Solicitacao solicitacao) {
		
		return ResponseEntity.ok(solicitacaoService.alterarStatus(solicitacao));
		
	}
}
