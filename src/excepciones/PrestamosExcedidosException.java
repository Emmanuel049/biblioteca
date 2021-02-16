package excepciones;

public class PrestamosExcedidosException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrestamosExcedidosException(){
		super();
	}
	
	public PrestamosExcedidosException(String mensaje) {
		super(mensaje);
	}
}
