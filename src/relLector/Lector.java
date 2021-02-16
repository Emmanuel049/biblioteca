package relLector;
import java.util.ArrayList;
import java.util.List;

import relLibro.Copia;
import relLibro.Libro;
import relLector.Prestamo;

public class Lector {
	//Defino la clase Lector para definir a los lectores, almacenandolos en el sistema simplemente escribiendo su nombre y generando una id personalizada, el id personalmente no es necesario para las implementaciones del sistema, pero puede traer utilidades a futuras modificaciones, como buscar un Lector por id en una base de datos o una búsqueda del nombre por id.
	private String nombre;
	private int id;
	private boolean multado = false;
	private static int aumentador = 0;
	private List<Prestamo> prestamos = new ArrayList<Prestamo>();
	
	//Constructor
	public Lector(String _nombre) {
		this.nombre = _nombre;
		this.id = aumentador;
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
	
	//Funciones Específicas
	public void prestarCopia(Prestamo _prestamo) {
		//La mayoría de las especificaciones de esta función están seteadas en Biblioteca.
		prestamos.add(_prestamo);
	}
	
	public int enumerarPrestamos() {
		int contador = prestamos.size();
		return contador;
	}
	
	public List<Prestamo> mostrarListaPrestamos(){
		//No sé si esto sea una mala práctica pero me fué muy útil el definir una lista de objetos Prestamo y sacarla para preguntarle cosas.
		return prestamos;
	}
	
	public void devuelveLibro(int _indice) {
		prestamos.remove(_indice);
	}
	
	protected void multar() {
		this.multado = true;
	}
	
	protected void sacarMulta() {
		this.multado = false;
	}
	
	public Prestamo getPrestamoLibro(Libro _libro) {
		for (int i = 0; i < this.prestamos.size();i++) {
			if (prestamos.get(i).getCopia().getLibroPerteneciente() == _libro) {
				return prestamos.get(i);
			}
		}
		return null;
	}
	
	public boolean libroPrestado(Libro _libro) {
		for (int i = 0; i < this.prestamos.size();i++) {
			if (prestamos.get(i).getCopia().getLibroPerteneciente() == _libro) {
				return true;
			}
		}
		return false;
	}
	
	public List<Copia> getListaCopiasPrestadas(){
		List<Copia> listaCopias = new ArrayList<Copia>();
		for (int i = 0; i < this.prestamos.size();i++) {
			listaCopias.add(prestamos.get(i).getCopia());
		}
		return listaCopias;
	}
}
