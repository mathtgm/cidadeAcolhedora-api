package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Imagem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.AnimalService;

@Service
public class AnimalImagemService {
	
	@Autowired
	private AnimalImagemRepository animalImagemRepository;
	
	@Autowired
	private AnimalService animalService;
	
	private final String pathArquivos;
	
	public AnimalImagemService(@Value("${app.path.imagens}") String pathArquivos) {
		this.pathArquivos = pathArquivos;
		
	}
	
	public AnimalImagem salvarImagem(MultipartFile imagem, Long id_animal) {
		  	
		AnimalImagem animalImagem = new AnimalImagem();
		Animal animal = animalService.findById(id_animal);
		
		String formato = FilenameUtils.getExtension(imagem.getOriginalFilename());
		String nomeArquivo = UUID.randomUUID() + "." + formato;
		String novoCaminho = pathArquivos + nomeArquivo;
		Path diretorioArquivo = Paths.get(novoCaminho);
		
		try {
			Files.copy(imagem.getInputStream(), diretorioArquivo, StandardCopyOption.REPLACE_EXISTING);
			
			animalImagem.setImagePath(nomeArquivo);
			animalImagem.setId_animal(animal);
				  
				  
		} catch (Exception e) {
				  
			System.out.println(e);
				  
		}
		
		return animalImagemRepository.save(animalImagem);
		  
	  }
	
	public byte[] findImagemByPathImagem(String pathImagem) {
		
		AnimalImagem animalImagem = animalImagemRepository.findByImagePath(pathImagem);
		String filePath = pathArquivos + animalImagem.getImagePath();
		
		byte[] imagem = null;
		
		try {
			
			imagem = Files.readAllBytes(new File(filePath).toPath());
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return imagem;
		
	}
	
	public void removerAnimalImagem(AnimalImagem imagem) {
		Path arquivo = Paths.get(pathArquivos + imagem.getImagePath());
		animalImagemRepository.deleteById(imagem.getId_imagem());
		
		try {
			
			Files.delete(arquivo);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		animalImagemRepository.deleteById(imagem.getId_imagem());
		
	}
}
