package excepciones;

public class ContieneLibroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContieneLibroException(){
		super();
	}
	
	public ContieneLibroException(String mensaje) {
		super(mensaje);
	}
}
