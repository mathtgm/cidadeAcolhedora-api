package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Imagem.AnimalImagem;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao.Solicitacao;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Usuario;
import br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao.Cidade;
import br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao.Estado;

@Entity
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_animal;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String tipo;
	
	@Column(length = 80, nullable = false)
	private String cor;
	
	@Column(nullable = false)
	private int idade;
	
	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private int nivelCarinho;
	
	@Column(nullable = false)
	private int nivelSociavel;
	
	@Column(nullable = false)
	private int nivelBrincalhao;
	
	@Column(nullable = false)
	private String descricao;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade idCidade;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado idEstado;
	
	@OneToOne
	@JoinColumn(name = "id_tutor")
	private Usuario idTutor;
	
	@OneToOne
	@JoinColumn(name = "id_doador")
	private Usuario idDoador;
	
	@OneToMany(mappedBy = "id_animal", cascade = CascadeType.REMOVE)
	private List<AnimalImagem> imagem;
	
	@OneToMany(mappedBy = "id_animal", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Solicitacao> solicitacoes;

	public Animal() {}
	
	public Animal(Long id_animal, String nome, String tipo, String cor, int idade, String sexo, int nivelCarinho,
			int nivelSociavel, int nivelBrincalhao, String descricao, Cidade idCidade, Estado idEstado, Usuario idTutor,
			Usuario idDoador, List<AnimalImagem> imagem) {
		super();
		this.id_animal = id_animal;
		this.nome = nome;
		this.tipo = tipo;
		this.cor = cor;
		this.idade = idade;
		this.sexo = sexo;
		this.nivelCarinho = nivelCarinho;
		this.nivelSociavel = nivelSociavel;
		this.nivelBrincalhao = nivelBrincalhao;
		this.descricao = descricao;
		this.idCidade = idCidade;
		this.idEstado = idEstado;
		this.idTutor = idTutor;
		this.idDoador = idDoador;
		this.imagem = imagem;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getNivelCarinho() {
		return nivelCarinho;
	}

	public void setNivelCarinho(int nivelCarinho) {
		this.nivelCarinho = nivelCarinho;
	}

	public int getNivelSociavel() {
		return nivelSociavel;
	}

	public void setNivelSociavel(int nivelSociavel) {
		this.nivelSociavel = nivelSociavel;
	}

	public int getNivelBrincalhao() {
		return nivelBrincalhao;
	}

	public void setNivelBrincalhao(int nivelBrincalhao) {
		this.nivelBrincalhao = nivelBrincalhao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AnimalImagem> getImagem() {
		return imagem;
	}

	public void setImagem(List<AnimalImagem> imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Animal [id_animal=" + id_animal + ", nome=" + nome + ", tipo=" + tipo + ", cor=" + cor + ", idade="
				+ idade + ", sexo=" + sexo + ", nivelCarinho=" + nivelCarinho + ", nivelSociavel=" + nivelSociavel
				+ ", nivelBrincalhao=" + nivelBrincalhao + ", descricao=" + descricao + ", idCidade=" + idCidade
				+ ", idEstado=" + idEstado + ", idTutor=" + idTutor + ", idDoador=" + idDoador + ", id_imagem="
				+ imagem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cor, descricao, idCidade, idDoador, idEstado, idTutor, id_animal, imagem, idade,
				nivelBrincalhao, nivelCarinho, nivelSociavel, nome, sexo, tipo);
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
		return Objects.equals(cor, other.cor) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(idCidade, other.idCidade) && Objects.equals(idDoador, other.idDoador)
				&& Objects.equals(idEstado, other.idEstado) && Objects.equals(idTutor, other.idTutor)
				&& Objects.equals(id_animal, other.id_animal) && Objects.equals(imagem, other.imagem)
				&& idade == other.idade && nivelBrincalhao == other.nivelBrincalhao
				&& nivelCarinho == other.nivelCarinho && nivelSociavel == other.nivelSociavel
				&& Objects.equals(nome, other.nome) && Objects.equals(sexo, other.sexo)
				&& Objects.equals(tipo, other.tipo);
	}
			
}