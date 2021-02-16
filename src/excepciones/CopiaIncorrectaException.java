package excepciones;

public class CopiaIncorrectaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CopiaIncorrectaException(){
		super();
	}
	
	public CopiaIncorrectaException(String mensaje) {
		super(mensaje);
	}
}