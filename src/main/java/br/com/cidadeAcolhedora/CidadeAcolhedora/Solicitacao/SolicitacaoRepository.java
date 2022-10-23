package br.com.cidadeAcolhedora.CidadeAcolhedora.Solicitacao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {
	
	@Query("FROM Solicitacao WHERE id_animal = :id_animal ORDER BY data_solicitacao DESC")
	public List<Solicitacao> findByIdAnimal(@Param("id_animal") Long id_animal);
	
	@Query("FROM Solicitacao WHERE id_adotante = :id_adotante ORDER BY data_solicitacao DESC")
	public List<Solicitacao> findByIdAdotante(@Param("id_adotante") Long id_adotante);
	
	

}
