package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cidade;
	
	private String nome; 
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	private Estado idEstado;
	
	public Cidade() {}

	public Cidade(Long id_cidade, String nome, Estado idEstado) {
		super();
		this.id_cidade = id_cidade;
		this.nome = nome;
		this.idEstado = idEstado;
	}

	public Long getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Long id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEstado, id_cidade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(idEstado, other.idEstado) && Objects.equals(id_cidade, other.id_cidade)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cidade [id_cidade=" + id_cidade + ", nome=" + nome + ", idEstado=" + idEstado + "]";
	}

}
