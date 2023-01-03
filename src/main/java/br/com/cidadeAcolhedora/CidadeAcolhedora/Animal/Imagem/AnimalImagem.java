package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Imagem;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;

@Entity
public class AnimalImagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_imagem;
	
	private String imagePath;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_animal")
	private Animal id_animal;
	
	public AnimalImagem() {}

	public AnimalImagem(Long id_imagem, String imagePath, Animal id_animal) {
		super();
		this.id_imagem = id_imagem;
		this.imagePath = imagePath;
		this.id_animal = id_animal;
	}

	public Long getId_imagem() {
		return id_imagem;
	}

	public void setId_imagem(Long id_imagem) {
		this.id_imagem = id_imagem;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Animal getId_animal() {
		return id_animal;
	}

	public void setId_animal(Animal id_animal) {
		this.id_animal = id_animal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_animal, id_imagem, imagePath);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalImagem other = (AnimalImagem) obj;
		return Objects.equals(id_animal, other.id_animal) && Objects.equals(id_imagem, other.id_imagem)
				&& Objects.equals(imagePath, other.imagePath);
	}

	@Override
	public String toString() {
		return "Animal_imagem [id_imagem=" + id_imagem + ", imagePath=" + imagePath + ", id_animal=" + id_animal + "]";
	}

	
}
