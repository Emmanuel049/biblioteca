public class Copia {
	//Implemento la clase Copia para almacenar los objetos de tipo Copia que ser�n necesarios para crear elementos que luego ser�n adjuntados a una lista en la clase Libro para definir "cuantas copias disponibles y totales tiene un libro". El cambio del estado de la copia es manual y solo es de inter�s para el sistema cuando la copia est� "en la biblioteca".
	
	String estado;
	int id;
	static int aumentador = 0;
	
	//Constructor
	public Copia(String _estado) {
		estado = _estado;
		id = aumentador;
		aumentador++;
	}
	
	//Setters
	public void cambiarEstado(String _estado) {
		estado = _estado;
	}
	
	//Getters
	public String getEstado() {
		return estado;
	}
	
	public int getId() {
		return id;
	}
}
