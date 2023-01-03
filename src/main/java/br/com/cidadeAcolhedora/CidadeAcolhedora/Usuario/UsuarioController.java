package br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cidadeAcolhedora.CidadeAcolhedora.ResponseDefault.ResponseDefault;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService userService;
	
	// #### METODOS GET ####
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario loginUsuario(@RequestBody Map<String, String> userData) {
				
		return userService.loginUsuario(userData.get("usuario"), userData.get("senha"));
		
	}
	
	@RequestMapping("/lista")
	public List<Usuario> listaUsuarios() {
		
		return userService.listaUsuarios();
		
	}
	
	@RequestMapping("/id/{id_usuario}")
	public Usuario findById(@PathVariable Long id_usuario) {
		
		return userService.findById(id_usuario);
		
	}
	
	// #### METODO PUT ####
	
	@PutMapping(path = "/cadastrar/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		
		return userService.cadastraUsuario(usuario);
		
	}
	
	@PutMapping(path = "/atualizar/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
		
		return ResponseEntity.ok(userService.atualizarUsuario(usuario));
	}
	
	// #### METODO DELETE ####
	
	@DeleteMapping("/remover/{id_usuario}")
	public ResponseEntity<ResponseDefault> deleteUsuarioById(@PathVariable Long id_usuario) {
		
		ResponseDefault res = new ResponseDefault();
		
		try {
		
			userService.deleteUsuario(id_usuario);
			
			res.setMessage("Usuário com ID " + id_usuario +" excluído com sucesso");
			res.setStatusCode(HttpStatus.OK);
			
			return ResponseEntity.status(HttpStatus.OK.value()).body(res);
			
		} catch (EmptyResultDataAccessException err) {
			
			res.setMessage("Id(" + id_usuario + ") do usuário não encontrado");
			res.setStatusCode(HttpStatus.NOT_FOUND);
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(res);
			
		}
		
	}
	
}
