package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estado;
	
	private String nome;
	
	@JsonIgnore
	@OneToMany(targetEntity = Cidade.class, mappedBy = "idEstado", fetch = FetchType.LAZY)
	private List<Cidade> cidades;
	
	public Estado() {}
	
	public Estado(Long id_estado, String nome, List<Cidade> cidades) {
		super();
		this.id_estado = id_estado;
		this.nome = nome;
		this.cidades = cidades;
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidades, id_estado, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(cidades, other.cidades) && Objects.equals(id_estado, other.id_estado)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", nome=" + nome + ", cidades=" + cidades + "]";
	}
	
	}
