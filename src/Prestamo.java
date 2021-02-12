import java.util.Date;

public class Prestamo {
	//La clase Prestamo solo recibe un elemento de la clase Copia, puesto a que est� dentro de una "lista de pr�stamos" en la clase Lector, de modo que se puede consultar esta lista de pr�stamos accediendo a una funci�n de Lector.
	
	Copia copia;
	Date fechaPrestamo;
	
	//Constructor
	public Prestamo(Copia _copia) {
		copia = _copia;
		fechaPrestamo = new Date();
	}
	
	//Getters
	public Copia getCopia() {
		return copia;
	}
	
	public Date getFecha() {
		return fechaPrestamo;
	}
}
