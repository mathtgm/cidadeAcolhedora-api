package br.com.cidadeAcolhedora.CidadeAcolhedora.Usuario.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNotFound() {
		super("Usuário/Senha incorretos.");
	}
	
}
