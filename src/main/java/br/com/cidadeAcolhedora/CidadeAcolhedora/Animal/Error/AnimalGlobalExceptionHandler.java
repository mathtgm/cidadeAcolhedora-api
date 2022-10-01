package br.com.cidadeAcolhedora.CidadeAcolhedora.Animal.Error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class AnimalGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AnimalNotFound.class)
	public void animalNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

}
