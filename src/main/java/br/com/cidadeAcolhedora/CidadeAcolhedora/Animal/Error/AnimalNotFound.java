package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimalNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AnimalNotFound(String campo, String valor) {super("Animal com " + campo + " " + valor + " não encontrado ");}

	public AnimalNotFound() {super("Animal não encontrado");}
}
