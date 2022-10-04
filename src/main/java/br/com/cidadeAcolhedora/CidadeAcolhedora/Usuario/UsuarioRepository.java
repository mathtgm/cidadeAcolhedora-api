package br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> { 

	public Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
	
}
