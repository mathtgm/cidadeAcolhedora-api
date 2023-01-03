package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Imagem;

import org.springframework.data.repository.CrudRepository;

public interface AnimalImagemRepository extends CrudRepository<AnimalImagem, Long> {
	
	public AnimalImagem findByImagePath(String imagePath);
}
