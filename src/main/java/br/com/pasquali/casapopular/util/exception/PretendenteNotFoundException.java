package br.com.pasquali.casapopular.util.exception;

/**
 * 
 * Criacao de nivel de excecoes para a utilizacao em falhas dos dados de entrada
 * 
 * @author Bruno Pinheiro
 *
 */
public class PretendenteNotFoundException extends PasqualiException {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Construtor default para mensagem
	 * 
	 */
    public PretendenteNotFoundException(String errorMessage) {
        super(errorMessage);
    }
    
}
