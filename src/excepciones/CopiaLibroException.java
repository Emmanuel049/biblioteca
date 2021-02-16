package excepciones;

public class CopiaLibroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CopiaLibroException(){
		super();
	}
	
	public CopiaLibroException(String mensaje) {
		super(mensaje);
	}
}