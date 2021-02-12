import java.util.ArrayList;
import java.util.List;

public class Lector {
	//Defino la clase Lector para definir a los lectores, almacenandolos en el sistema simplemente escribiendo su nombre y generando una id personalizada, el id personalmente no es necesario para las implementaciones del sistema, pero puede traer utilidades a futuras modificaciones, como buscar un Lector por id en una base de datos o una b�squeda del nombre por id.
	String nombre;
	int id;
	boolean multado = false;
	static int aumentador = 0;
	private List<Prestamo> prestamos = new ArrayList();
	
	//Constructor
	public Lector(String _nombre) {
		nombre = _nombre;
		id = aumentador;
		aumentador++;
	}
	
	//Getters
	public String getNombre(){
		return nombre;
	}
	
	public int getId() {
		return id;
	}	
	
	public boolean estaMultado() {
		return multado;
	}
	
	//Funciones Espec�ficas
	public void prestarCopia(Prestamo _prestamo) {
		//La mayor�a de las especificaciones de esta funci�n est�n seteadas en Biblioteca.
		prestamos.add(_prestamo);
	}
	
	public int enumerarPrestamos() {
		int contador = prestamos.size();
		return contador;
	}
	
	public List<Prestamo> mostrarListaPrestamos(){
		//No s� si esto sea una mala pr�ctica pero me fu� muy �til el definir una lista de objetos Prestamo y sacarla para preguntarle cosas.
		return prestamos;
	}
	
	public void devolverLibro(int _indice) {
		prestamos.remove(_indice);
	}
	
	public void multar() {
		multado = true;
	}
	
	public void sacarMulta() {
		multado = false;
	}
	

}
