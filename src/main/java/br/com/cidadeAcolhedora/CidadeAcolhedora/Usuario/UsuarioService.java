package br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Error.UsuarioNotFound;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	// Valida se o usuario e senha existem e retorna um usuario
	public Usuario loginUsuario(String usuario, String senha) {
		
		Optional<Usuario> optValue = usuarioRepository.findByUsuarioAndSenha(usuario, senha); 
		
		return optValue.orElseThrow(() -> new UsuarioNotFound());
		
	}
	
	// Adiciona um usuario no banco de dados
	public Usuario cadastraUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
	// Procura usuario pelo ID	
	public Usuario findById(Long id) {
		
		Optional<Usuario> optValue = usuarioRepository.findById(id);
		
		optValue.orElseThrow(() -> new UsuarioNotFound());
		
		return optValue.get();
		
	}
	
	// Lista todos os usuario do banco de dados
	public List<Usuario> listaUsuarios() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
	}
	
	public void deleteUsuario(Long id_usuario) {
		
		usuarioRepository.deleteById(id_usuario);
		
	}

	public Usuario atualizarUsuario(Usuario usuario) {

		Usuario usuarioTemp = usuarioRepository.findById(usuario.getId_usuario()).get();
		
		usuarioTemp.setCidade(usuario.getCidade());
		usuarioTemp.setEstado(usuario.getEstado());
		usuarioTemp.setDocumento(usuario.getDocumento());
		usuarioTemp.setGenero(usuario.getGenero());
		usuarioTemp.setNome(usuario.getNome());
		usuarioTemp.setTelefone(usuario.getTelefone());
		
		return usuarioRepository.save(usuarioTemp);
	}
	
}
