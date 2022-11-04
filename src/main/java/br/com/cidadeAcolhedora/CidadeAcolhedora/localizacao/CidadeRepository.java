package br.com.cidadeAcolhedora.CidadeAcolhedora.localizacao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CidadeRepository extends CrudRepository<Cidade, Long>{
	
	@Query("FROM Cidade WHERE id_estado = :id_estado")
	public List<Cidade>findEstadoById(@Param("id_estado") Long id_estado);
}
