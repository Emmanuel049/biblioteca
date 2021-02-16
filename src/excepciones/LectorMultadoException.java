package excepciones;

public class LectorMultadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LectorMultadoException(){
		super();
	}
	
	public LectorMultadoException(String mensaje) {
		super(mensaje);
	}
}
