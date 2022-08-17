package br.com.pasquali.casapopular.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pasquali.casapopular.util.exception.DadosInvalidosException;
import br.com.pasquali.casapopular.util.exception.PretendenteNotFoundException;

/**
 * 
 * Classe responsavel pelo tratamento de excecoes lancadas para além da camada rest.
 * Apresenta a mensagem da falha para o cliente da ponta
 * 
 * @author bruno.pinheiro
 *
 */
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = DadosInvalidosException.class)
	public ResponseEntity<String> exception422(DadosInvalidosException exception) {
		return new ResponseEntity<>("422: " + exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exception500(Exception exception) {
		return new ResponseEntity<>("500: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = PretendenteNotFoundException.class)
	public ResponseEntity<String> exception422(PretendenteNotFoundException exception) {
		return new ResponseEntity<>("404: " + exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}