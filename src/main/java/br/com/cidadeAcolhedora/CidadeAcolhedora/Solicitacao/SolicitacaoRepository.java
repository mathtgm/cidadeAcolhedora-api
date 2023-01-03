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
	
	@Query(nativeQuery = true, value = "SELECT * FROM Solicitacao WHERE id_adotante = :id_adotante ORDER BY data_solicitacao DESC LIMIT 5")
	public List<Solicitacao> findById_AdotanteLimite(@Param("id_adotante") Usuario id_adotante);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Solicitacao WHERE id_animal = :id_animal ORDER BY data_solicitacao DESC LIMIT 5")
	public List<Solicitacao> findById_AnimalLimite(@Param("id_animal") Animal id_animal);

	@Query(nativeQuery = true, value = "SELECT * FROM Solicitacao WHERE id_animal = :id_animal AND id_adotante = :id_adotante")
	public Solicitacao findByIdAnimalAndIdAdotante(@Param("id_animal") Long id_animal, @Param("id_adotante") Long id_adotante);
	
	@Query(nativeQuery = true, value = "SELECT * FROM solicitacao WHERE id_animal IN (SELECT id_animal FROM animal WHERE id_doador = :id_doador AND id_tutor IS NULL)")
	public List<Solicitacao> findByIdDoador(@Param("id_doador") Long id_doador);
}
