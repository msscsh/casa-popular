package br.com.pasquali.casapopular.util.exception;

/**
 * 
 * Classe de excessao raiz para este sistema
 * 
 * @author Bruno Pinheiro
 *
 */
public class PasqualiException extends RuntimeException {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Construtor default para mensagem
	 * 
	 */
    public PasqualiException(String errorMessage) {
        super(errorMessage);
    }
    
    /**
     * 
     * construtor com cause
     * 
     * @param errorMessage
     * @param cause
     */
    public PasqualiException(String errorMessage, Throwable cause) {
        super(errorMessage);
        initCause(cause);
    }
	
    /**
     * 
     * Inicializa a causa
     * 
     */
    @Override
    public synchronized Throwable initCause(Throwable cause) {
    	return super.initCause(cause);
    }
    
}
