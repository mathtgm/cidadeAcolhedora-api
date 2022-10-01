package br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
	@Column(length = 120, nullable = false)
	private String nome;
	
	@Column(length = 15, nullable = false)
	private String documento;
	
	@Column(length = 15, nullable = false)
	private String telefone;
	
	@Column(length = 15, nullable = false)
	private String cidade;
	
	@Column(length = 15, nullable = false)
	private String estado;
	
	@JsonIgnore
	@Column(length = 20, nullable = false)
	private String usuario;
	
	@JsonIgnore
	@Column(length = 16, nullable = false)
	private String senha;
	
	@JsonIgnore
	@OneToMany(targetEntity = Animal.class, mappedBy = "idTutor")
	private List<Animal> listaAnimaisTutelados;
	
	@JsonIgnore
	@OneToMany(targetEntity = Animal.class, mappedBy = "idDoador")
	private List<Animal> listaAnimaisAdocao;

	public Usuario() {}

	public Usuario(int id_usuario, String nome, String documento, String telefone, String cidade, String estado,
			String usuario, String senha, List<Animal> listaAnimaisTutelados, List<Animal> listaAnimaisAdocao) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.cidade = cidade;
		this.estado = estado;
		this.usuario = usuario;
		this.senha = senha;
		this.listaAnimaisTutelados = listaAnimaisTutelados;
		this.listaAnimaisAdocao = listaAnimaisAdocao;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	@Override
	public int hashCode() {
		return Objects.hash(cidade, documento, estado, id_usuario, listaAnimaisAdocao, listaAnimaisTutelados, nome,
				senha, telefone, usuario);
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
				&& Objects.equals(estado, other.estado) && id_usuario == other.id_usuario
				&& Objects.equals(listaAnimaisAdocao, other.listaAnimaisAdocao)
				&& Objects.equals(listaAnimaisTutelados, other.listaAnimaisTutelados)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome=" + nome + ", documento=" + documento + ", telefone="
				+ telefone + ", cidade=" + cidade + ", estado=" + estado + ", usuario=" + usuario + ", senha=" + senha
				+ ", listaAnimaisTutelados=" + listaAnimaisTutelados + ", listaAnimaisAdocao=" + listaAnimaisAdocao
				+ "]";
	}

}
