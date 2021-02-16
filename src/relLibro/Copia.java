package relLibro;

import excepciones.CopiaIncorrectaException;
import excepciones.CopiaLibroException;

public class Copia {
	//Implemento la clase Copia para almacenar los objetos de tipo Copia que serán necesarios para crear elementos que luego serán adjuntados a una lista en la clase Libro para definir "cuantas copias disponibles y totales tiene un libro". El cambio del estado de la copia es manual y solo es de interés para el sistema cuando la copia esté "en la biblioteca".
	
	private String estado;
	private int id;
	private static int aumentador = 0;
	private Libro libroPerteneciente;
	
	//Constructor
	public Copia(String _estado) throws CopiaIncorrectaException {
		if (_estado == "en la biblioteca" || _estado == "prestada" || _estado == "con retraso" || _estado == "en reparación") {
			this.estado = _estado;
			this.id = aumentador;
			aumentador++;
		}
		else {
			throw new CopiaIncorrectaException("El tipo ingresado: "+_estado+" no es válido.");
		}
	}
	
	//Setters
	public void cambiarEstado(String _estado) throws CopiaLibroException, CopiaIncorrectaException {
		if(_estado == "en la biblioteca" || _estado == "prestada" || _estado == "con retraso" || _estado == "en reparación") {
			this.estado = _estado;
		}
		else {
			throw new CopiaIncorrectaException("El tipo ingresado: "+_estado+" no es válido.");
		}
	}
	
	public void perteneceLibro(Libro libro) {
		this.libroPerteneciente = libro;
	}
	
	//Getters
	public String getEstado() {
		return estado;
	}
	
	public int getId() {
		return id;
	}
	
	public Libro getLibroPerteneciente() {
		return this.libroPerteneciente;
	}
}
