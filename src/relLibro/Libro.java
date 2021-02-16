package relLibro;

//Importaciones de excepciones personalizadas
import excepciones.CopiaLibroException;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	//Utilizo la clase Libro para almacenar a los objetos que sirven para identificar el libro que busca el "Lector", a esta clase le dí la particularidad de que pueda crearse sin necesidad de pertenecer a uno de los tipos de libros que la biblioteca requiere, esto trae bugs en el programa cuando en la clase biblioteca se quiere agregar un libro que no cumple las especificaciones, esto puede tener mejoras en la implementación y en "no repetir código".
	
	private String titulo,tipo,editorial;
	private Autor autor;
	private int año, id;
	private static int aumentador = 0;
	private List<Copia> copiasTotales = new ArrayList<Copia>();
	private List<Copia> copiasDisponibles = new ArrayList<Copia>();
	
	//Constructor
	public Libro(String _titulo, String _tipo, String _editorial, int _año, Autor _autor) {
		this.titulo = _titulo;
		this.tipo = _tipo;
		this.editorial = _editorial;
		this.año = _año;
		this.autor = _autor;
		this.id = aumentador;
		aumentador ++;
	}
	
	//Getters
	public String getNombre() {
		return this.titulo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String getEditorial() {
		return this.editorial;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getAño() {
		return this.año;
	}
	
	public Autor getAutor() {
		return this.autor;
	}
	
	public int enumerarCopias() {
		//Devuelve la cantidad de copias totales vinculadas al libro
		return copiasTotales.size();
	}
	
	public int enumerarDisponibles() {
		//Devuelve la cantidad de copias disponibles vinculadas al libro
		return copiasDisponibles.size();
	}
	
	//Funciones Específicas
	public void enlistarCopia(Copia elemento) {
		//Enlista un elemento Copia a la lista de copias totales del libro
		copiasTotales.add(elemento);
	}
	
	public void sacarCopia(Copia _copia) throws CopiaLibroException {
		//Remueve un elemento Copia de la lista de copias totales del libro si existe el elemento en la lista, de lo contrario lanzará una excepción
		if (copiasTotales.contains(_copia)) {
			copiasTotales.remove(_copia);
		}
		else {
			throw new CopiaLibroException("No existe esa copia relacionada con el libro: "+titulo);
		}
	}
	
	public void enlistarDisponible(Copia elemento) {
		//Enlista un elemento Copia a la lista de copias disponibles del libro
		copiasDisponibles.add(elemento);
	}
	
	public void sacarDisponible(Copia _copia) throws CopiaLibroException {
		//Remueve un elemento Copia de la lista de copias disponibles del libro si existe el elemento en la lista, de lo contrario lanzará una excepción
		if (copiasDisponibles.contains(_copia)) {
			copiasDisponibles.remove(_copia);
		}
		else {
			throw new CopiaLibroException("No existe esa copia disponible relacionada con el libro: "+titulo);
		}
	}
	
	public Copia entregarCopia() {
		//Entrega una copia del libro a la biblioteca (las verificaciones de esto y el destinatario de dicha copia están verificados en la clase Biblioteca)
		int indice = copiasDisponibles.size()-1;
		Copia removido = copiasDisponibles.get(indice);
		copiasDisponibles.remove(indice);
		return removido;
	}
}
