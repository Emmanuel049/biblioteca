import java.util.Date;

public class Prestamo {
	//La clase Prestamo solo recibe un elemento de la clase Copia, puesto a que está dentro de una "lista de préstamos" en la clase Lector, de modo que se puede consultar esta lista de préstamos accediendo a una función de Lector.
	
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
