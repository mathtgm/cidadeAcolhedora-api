package br.com.cidadeAcolhedora.Usuario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.cidadeAcolhedora.Animal.Animal;

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
	
	@Column(length = 20, nullable = false)
	private String usuario;
	
	@Column(length = 16, nullable = false)
	private String senha;
	
	@OneToOne(targetEntity = Animal.class, mappedBy = "id_doador")
	private List<Animal> doando;
	
	@OneToOne(targetEntity = Animal.class, mappedBy = "id_tutor")
	private List<Animal> adotando;
	
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
	
	
	
}
