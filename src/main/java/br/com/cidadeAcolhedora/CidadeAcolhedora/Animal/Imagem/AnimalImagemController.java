package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Imagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("animal/imagem/")
public class AnimalImagemController {

	@Autowired
	private AnimalImagemService animalImagemService;
	
	@PostMapping(path = "cadastrar/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<AnimalImagem> saveAnimalImagem(@RequestParam Long animal, @RequestParam MultipartFile imagem) {
		
		return ResponseEntity.ok().body(animalImagemService.salvarImagem(imagem, animal));
		
	}
	
	@RequestMapping(path = "{nome_imagem}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<byte[]> procurarImagem(@PathVariable String nome_imagem) {
		
		byte[] imagem = animalImagemService.findImagemByPathImagem(nome_imagem);
		return ResponseEntity.ok().body(imagem);
		
	}
	
	@DeleteMapping(path = "remover/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnimalImagem> removerAnimalImagem(@RequestBody AnimalImagem imagem) {
		
		animalImagemService.removerAnimalImagem(imagem);
		return ResponseEntity.ok().body(imagem);
		
	}
}
