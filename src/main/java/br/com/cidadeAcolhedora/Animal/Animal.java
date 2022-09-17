package br.com.cidadeAcolhedora.Animal;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.cidadeAcolhedora.Usuario.Usuario;

@Entity
public class Animal{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_animal;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String raca;
	
	@Column(length = 80, nullable = false)
	private String cor;
	
	@OneToOne
	private Usuario id_tutor;
	
	@OneToOne
	private Usuario id_doador;
	
	public Animal() {}

	public Animal(int id_animal, String nome, String raca, String cor, Usuario id_tutor, Usuario id_doador) {
		super();
		this.id_animal = id_animal;
		this.nome = nome;
		this.raca = raca;
		this.cor = cor;
		this.id_tutor = id_tutor;
		this.id_doador = id_doador;
	}



	public int getId_animal() {
		return id_animal;
	}

	public void setId_animal(int id_animal) {
		this.id_animal = id_animal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Usuario getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(Usuario id_tutor) {
		this.id_tutor = id_tutor;
	}

	public Usuario getId_doador() {
		return id_doador;
	}

	public void setId_doador(Usuario id_doador) {
		this.id_doador = id_doador;
	}

	@Override
	public String toString() {
		return "Animal [id_animal=" + id_animal + ", nome=" + nome + ", raca=" + raca + ", cor=" + cor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cor, id_animal, nome, raca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(cor, other.cor) && id_animal == other.id_animal && Objects.equals(nome, other.nome)
				&& Objects.equals(raca, other.raca);
	}
		
}
