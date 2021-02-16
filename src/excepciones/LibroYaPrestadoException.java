package excepciones;

public class LibroYaPrestadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LibroYaPrestadoException(){
		super();
	}
	
	public LibroYaPrestadoException(String mensaje) {
		super(mensaje);
	}
}
