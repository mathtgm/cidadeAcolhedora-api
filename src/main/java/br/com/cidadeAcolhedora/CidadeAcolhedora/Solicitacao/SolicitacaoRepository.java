package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Animal;
import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Usuario;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {
	
	@Query("FROM Solicitacao WHERE id_animal = :id_animal ORDER BY data_solicitacao DESC")
	public List<Solicitacao> findById_Animal(@Param("id_animal") Animal id_animal);
	
	@Query("FROM Solicitacao WHERE id_adotante = :id_adotante ORDER BY data_solicitacao DESC")
	public List<Solicitacao> findById_Adotante(@Param("id_adotante") Usuario id_adotante);
	
	

}
