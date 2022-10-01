package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnimalRepository extends CrudRepository<Animal, Long>{
	
	@Query("FROM Animal WHERE nome LIKE %:nome%")
	public Optional<List<Animal>> findByNome(@Param("nome") String nome);
	
	public Optional<List<Animal>> findByTipo(String tipo);
	
	@Query("FROM Animal WHERE id_cidade = :id_cidade")
	public Optional<List<Animal>> findByCidade(@Param("id_cidade") int id_cidade);
	
	@Query("FROM Animal WHERE id_estado = :id_estado")
	public Optional<List<Animal>> findByEstado(@Param("id_estado") int id_estado);
	
	@Query("FROM Animal WHERE id_doador = :id_doador")
	public Optional<List<Animal>> findById_doador(@Param("id_doador") int id_doador);
	
	@Query("FROM Animal WHERE id_tutor = :id_tutor")
	public Optional<List<Animal>> findById_tutor(@Param("id_tutor") int id_tutor);
	
}
