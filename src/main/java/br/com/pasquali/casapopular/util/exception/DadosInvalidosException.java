package br.com.pasquali.casapopular.util.exception;

/**
 * 
 * Criacao de nivel de excecoes para a utilizacao em falhas dos dados de entrada
 * 
 * @author Bruno Pinheiro
 *
 */
public class DadosInvalidosException extends PasqualiException {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Construtor default para mensagem
	 * 
	 */
    public DadosInvalidosException(String errorMessage) {
        super(errorMessage);
    }
    
}
