import java.util.ArrayList;
import java.util.List;

public class Libro {
	//Utilizo la clase Libro para almacenar a los objetos que sirven para identificar el libro que busca el "Lector", a esta clase le dí la particularidad de que pueda crearse sin necesidad de pertenecer a uno de los tipos de libros que la biblioteca requiere, esto trae bugs en el programa cuando en la clase biblioteca se quiere agregar un libro que no cumple las especificaciones, esto puede tener mejoras en la implementación y en "no repetir código".
	
	String titulo,tipo,editorial;
	Autor autor;
	int año, id;
	static int aumentador = 0;
	private List<Copia> copiasTotales = new ArrayList();
	private List<Copia> copiasDisponibles = new ArrayList();
	
	//Constructor
	public Libro(String _titulo, String _tipo, String _editorial, int _año, Autor _autor) {
		titulo = _titulo;
		tipo = _tipo;
		editorial = _editorial;
		año = _año;
		autor = _autor;
		id = aumentador;
		aumentador ++;
	}
	
	//Getters
	public String getNombre() {
		return titulo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int enumerarCopias() {
		return copiasTotales.size();
	}
	
	public int enumerarDisponibles() {
		return copiasDisponibles.size();
	}
	
	//Funciones Específicas
	public void enlistarCopia(Copia elemento) {
		copiasTotales.add(elemento);
	}
	
	public void sacarCopia(Copia _copia) {
		if (copiasTotales.contains(_copia)) {
			copiasTotales.remove(_copia);
		}
		else {
			System.out.println("No existe esa copia relacionada con el libro: "+titulo);
		}
	}
	
	public void enlistarDisponible(Copia elemento) {
		copiasDisponibles.add(elemento);
	}
	
	public void sacarDisponible(Copia _copia) {
		if (copiasDisponibles.contains(_copia)) {
			copiasDisponibles.remove(_copia);
		}
		else {
			System.out.println("No existe esa copia disponible relacionada con el libro: "+titulo);
		}
	}
	
	public Copia entregarCopia() {
		int indice = copiasDisponibles.size()-1;
		Copia removido = copiasDisponibles.get(indice);
		copiasDisponibles.remove(indice);
		return removido;
	}
}
