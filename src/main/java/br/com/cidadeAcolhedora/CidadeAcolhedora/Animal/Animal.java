package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Imagem.AnimalImagem;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Usuario;
import br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao.Cidade;
import br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao.Estado;

@Entity
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_animal;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String tipo;
	
	@Column(length = 80, nullable = false)
	private String cor;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade idCidade;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado idEstado;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tutor")
	private Usuario idTutor;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_doador")
	private Usuario idDoador;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_imagem")
	private List<AnimalImagem> id_imagem;
	
	public Animal() {}

	public Animal(Long id_animal, String nome, String tipo, String cor, Cidade idCidade, Estado idEstado,
			Usuario idTutor, Usuario idDoador, List<AnimalImagem> id_imagem) {
		super();
		this.id_animal = id_animal;
		this.nome = nome;
		this.tipo = tipo;
		this.cor = cor;
		this.idCidade = idCidade;
		this.idEstado = idEstado;
		this.idTutor = idTutor;
		this.idDoador = idDoador;
		this.id_imagem = id_imagem;
	}



	public Long getId_animal() {
		return id_animal;
	}

	public void setId_animal(Long id_animal) {
		this.id_animal = id_animal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Cidade getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Cidade idCidade) {
		this.idCidade = idCidade;
	}

	public Estado getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
	}

	public Usuario getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(Usuario idTutor) {
		this.idTutor = idTutor;
	}

	public Usuario getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Usuario idDoador) {
		this.idDoador = idDoador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<AnimalImagem> getId_imagem() {
		return id_imagem;
	}

	public void setId_imagem(List<AnimalImagem> id_imagem) {
		this.id_imagem = id_imagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cor, idCidade, idDoador, idEstado, idTutor, id_animal, id_imagem, nome, tipo);
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
		return Objects.equals(cor, other.cor) && Objects.equals(idCidade, other.idCidade)
				&& Objects.equals(idDoador, other.idDoador) && Objects.equals(idEstado, other.idEstado)
				&& Objects.equals(idTutor, other.idTutor) && Objects.equals(id_animal, other.id_animal)
				&& Objects.equals(id_imagem, other.id_imagem) && Objects.equals(nome, other.nome)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Animal [id_animal=" + id_animal + ", nome=" + nome + ", tipo=" + tipo + ", cor=" + cor + ", idCidade="
				+ idCidade + ", idEstado=" + idEstado + ", idTutor=" + idTutor + ", idDoador=" + idDoador
				+ ", id_imagem=" + id_imagem + "]";
	}
			
}