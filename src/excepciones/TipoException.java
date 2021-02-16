package excepciones;

public class TipoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoException(){
		super();
	}
	
	public TipoException(String mensaje) {
		super(mensaje);
	}
}
