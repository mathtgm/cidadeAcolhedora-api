package br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;
import br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao.Cidade;
import br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao.Estado;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column(length = 120)
	private String nome;
	
	@Column(length = 15)
	private String documento;
	
	@Column(length = 15)
	private String telefone;
	
	@Column(length = 9)
	private char genero;
	
	@Column(length = 20)
	private String usuario;
	
	@Column(length = 16)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String senha;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	@JsonIgnore
	@OneToMany(targetEntity = Animal.class, mappedBy = "idTutor")
	private List<Animal> listaAnimaisTutelados;
	
	@JsonIgnore
	@OneToMany(targetEntity = Animal.class, mappedBy = "idDoador")
	private List<Animal> listaAnimaisAdocao;

	public Usuario() {}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Animal> getListaAnimaisTutelados() {
		return listaAnimaisTutelados;
	}

	public void setListaAnimaisTutelados(List<Animal> listaAnimaisTutelados) {
		this.listaAnimaisTutelados = listaAnimaisTutelados;
	}

	public List<Animal> getListaAnimaisAdocao() {
		return listaAnimaisAdocao;
	}

	public void setListaAnimaisAdocao(List<Animal> listaAnimaisAdocao) {
		this.listaAnimaisAdocao = listaAnimaisAdocao;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, documento, estado, genero, id_usuario, listaAnimaisAdocao, listaAnimaisTutelados,
				nome, senha, telefone, usuario);
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(documento, other.documento)
				&& Objects.equals(estado, other.estado) && Objects.equals(genero, other.genero)
				&& id_usuario == other.id_usuario && Objects.equals(listaAnimaisAdocao, other.listaAnimaisAdocao)
				&& Objects.equals(listaAnimaisTutelados, other.listaAnimaisTutelados)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome=" + nome + ", documento=" + documento + ", telefone="
				+ telefone + ", genero=" + genero + ", cidade=" + cidade + ", estado=" + estado + ", usuario=" + usuario
				+ ", senha=" + senha + ", listaAnimaisTutelados=" + listaAnimaisTutelados + ", listaAnimaisAdocao="
				+ listaAnimaisAdocao + "]";
	}

}
