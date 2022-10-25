package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Usuario;

@Entity
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_solicitacao;
	
	@OneToOne
	@JoinColumn(name = "id_animal")
	private Animal id_animal;
	
	@OneToOne
	@JoinColumn(name = "id_adotante")
	private Usuario id_adotante;
	
	private LocalDateTime data_solicitacao;
	private String descricao;
	
	
//	A = Aberto
//	B = Em Analise
//	C = Recusado
//	D = Aprovado
	private char situacao;
	
	public Solicitacao() {
		super();
	}

	public Solicitacao(Long id_solicitacao, Animal id_animal, Usuario id_adotante, LocalDateTime data_solicitacao,
			String descricao, char situacao) {
		super();
		this.id_solicitacao = id_solicitacao;
		this.id_animal = id_animal;
		this.id_adotante = id_adotante;
		this.data_solicitacao = data_solicitacao;
		this.descricao = descricao;
		this.situacao = situacao;
	}

	public Long getId_solicitacao() {
		return id_solicitacao;
	}
	
	public void setId_solicitacao(Long id_solicitacao) {
		this.id_solicitacao = id_solicitacao;
	}
	
	public Animal getId_animal() {
		return id_animal;
	}
	
	public void setId_animal(Animal id_animal) {
		this.id_animal = id_animal;
	}
	
	public Usuario getId_adotante() {
		return id_adotante;
	}
	
	public void setId_adotante(Usuario id_adotante) {
		this.id_adotante = id_adotante;
	}
	
	public LocalDateTime getData_solicitacao() {
		return data_solicitacao;
	}
	
	public void setData_solicitacao(LocalDateTime data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public char getSituacao() {
		return situacao;
	}
	
	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_solicitacao, descricao, id_adotante, id_animal, id_solicitacao, situacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		return Objects.equals(data_solicitacao, other.data_solicitacao) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id_adotante, other.id_adotante) && Objects.equals(id_animal, other.id_animal)
				&& Objects.equals(id_solicitacao, other.id_solicitacao) && situacao == other.situacao;
	}

	@Override
	public String toString() {
		return "Solicitacao [id_solicitacao=" + id_solicitacao + ", id_animal=" + id_animal + ", id_adotante="
				+ id_adotante + ", data_solicitacao=" + data_solicitacao + ", descricao=" + descricao + ", situacao="
				+ situacao + "]";
	}	
	
}
