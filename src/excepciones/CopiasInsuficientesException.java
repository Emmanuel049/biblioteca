package excepciones;

public class CopiasInsuficientesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CopiasInsuficientesException(){
		super();
	}
	
	public CopiasInsuficientesException(String mensaje) {
		super(mensaje);
	}
}
