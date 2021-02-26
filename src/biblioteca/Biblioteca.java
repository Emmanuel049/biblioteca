package biblioteca;

//Importaciones necesarias del paquete de las clases relacionadas a los Libros
import relLibro.Libro;
import relLibro.Copia;

//Importaciones necesarias del paquete de las clases relacionadas a los Lectores
import relLector.Lector;
import relLector.Multa;
import relLector.Prestamo;

//Importaciones de excepciones personalizadas
import excepciones.ContieneLibroException;
import excepciones.CopiaIncorrectaException;
import excepciones.CopiaLibroException;
import excepciones.TipoException;
import excepciones.CopiasInsuficientesException;
import excepciones.LectorMultadoException;
import excepciones.LibroYaPrestadoException;
import excepciones.PrestamosExcedidosException;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Biblioteca {
	//Clase principal que maneja todo el sistema, utilic� Biblioteca como sistema "padre" puesto a que puedo hacer verificaciones en la mayor�a de las clases y ordeno la mayor�a de las funciones del c�digo desde ac�. Tambi�n abre la posibilidad de abrir varias Bibliotecas con distintas reglas y par�metros.
	
	//Utilic� una lista de libros y una lista de multas con la informaci�n de las multas vigentes, la idea es recorrer ambas listas y revisar "que libros se tienen en la biblioteca" y "las multas vigentes(las cuales al navegar por ellas podremos sacar informaci�n como la fecha de expiraci�n, la de recepci�n de la multa y el Lector multado)" y luego revisar cuantas "copias" se tienen del libro como funci�n en la clase Libro.
	private List<Libro> libros = new ArrayList<Libro>();
	private List<Multa> listaMultas = new ArrayList<Multa>();
	
	public void agregarLibro(Libro _libro) throws TipoException{
		//Esta funci�n es para verificar que el libro cumpla los tipos especificados, de no ser as� el libro se crea pero no se agrega a la lista de "libros disponibles de la biblioteca", esto trae bugs puesto a que en algunas funciones llam� directamente a la clase libros y est� abierto a futuras revisiones.
		verificarTipo(_libro.getTipo());
		libros.add(_libro);
		
	}
	
	private void verificarTipo(String _tipo) throws TipoException {
		if (_tipo == "novela" || _tipo == "teatro" || _tipo == "poesia" || _tipo == "ensayo") {}
		else {
			throw new TipoException("No se pudo agregar el libro. El libro tiene un tipo inv�lido para la biblioteca.");
		}
	}
	
	public void desenlistarLibro(Libro _libro) throws ContieneLibroException {
		//Con esta funci�n desenlisto un libro de la lista de libros de la biblioteca, de esta manera podemos "sacar" un libro de nuestra biblioteca (o al menos de cara al p�blico).
		if (libros.contains(_libro)) {
			libros.remove(_libro);
		}
		else {
			throw new ContieneLibroException("El libro "+_libro.getNombre()+" que desea desenlistar no est� en la biblioteca.");
		}
	}
	
	public void prestarLibro(Libro _libro,Lector _lector) throws CopiasInsuficientesException, LectorMultadoException, PrestamosExcedidosException, CopiaLibroException, CopiaIncorrectaException, LibroYaPrestadoException{
		//Con prestarLibro utilizo un algoritmo que verifica que el lector no tenga 3 o m�s libros y que no est� multado a la hora de prestar un libro, en caso negativo se manda un mensaje por consola, lo mismo si no hay stock de dicho libro.
		if (_lector.enumerarPrestamos() < 3) {
			if(!(_lector.estaMultado())){
				if (_libro.enumerarDisponibles() > 0) {
					if (_lector.libroPrestado(_libro)) {
						throw new LibroYaPrestadoException("El libro: "+_libro.getNombre()+" ya fu� prestado al lector: "+_lector.getNombre()+". Solo puede prestarse un libro con el mismo nombre a cada lector al mismo tiempo.");
					}
					else {
						Copia copiaEntregada = _libro.entregarCopia();
						Prestamo prestamo = new Prestamo(copiaEntregada);
						_lector.prestarCopia(prestamo);
						copiaEntregada.cambiarEstado("prestada");
					}
				}
				else {
					throw new CopiasInsuficientesException("No quedan copias disponibles del libro: "+_libro.getNombre()+" en stock.");
				}
			}
			else {
				throw new LectorMultadoException("El lector "+_lector.getNombre()+" est� multado.");
			}
		}
		else {
			throw new PrestamosExcedidosException("El lector "+_lector.getNombre()+" tiene m�s de 3 pr�stamos actuales.");
		}
	}
	
	public void nuevaCopia(Copia _copia, Libro _libro) {
		//Con esta funci�n determino a que libro pertenece una copia
		_libro.enlistarCopia(_copia);
		if (_copia.getEstado() == "en la biblioteca") {
			_libro.enlistarDisponible(_copia);
		}
		_copia.perteneceLibro(_libro);
	}
	
	public void devolverLibro(Copia _copia, Lector _lector) throws CopiaLibroException, CopiaIncorrectaException {
		//Con devolver libro tengo un algoritmo algo m�s complejo, tuve una larga investigaci�n sobre el m�todo "Date" y determin� que puedo "dividir" por "86400000" cada valor resultante del m�dulo .getTime() para tener una cantidad real de d�as resultantes a dicha fecha, este c�lculo determina la resta entre el d�a actual y el d�a de entrega, si el resultado es mayor a 30, se toma la diferencia y se env�a como diasPasados a la clase Multa para hacer un c�lculo del d�a en el que reci�n podr� sacarse la booleana multado dentro de la clase Lector.
		List<Prestamo> listaPrestamos = _lector.mostrarListaPrestamos();
		boolean estaCopia = false;
		for (int i = 0; i < listaPrestamos.size(); i++) {
			//Este "i" me es �til m�s abajo para determinar la posici�n de la lista de pr�stamos donde est� la copia que quiero "devolver" para eliminar el objeto de la l�sta en dicha posici�n.
			Prestamo campo = listaPrestamos.get(i);
			
			if (campo.getCopia() == _copia) {
				estaCopia = true;
				int milisecondsByDay = 86400000;
				Date fechaActual = new Date();
				int diasPasados = (int) (fechaActual.getTime()/milisecondsByDay - campo.getFecha().getTime()/milisecondsByDay);
				if (diasPasados > 30) {			//Si los d�as pasados ameritan una multa entrar� en 2 posibilidades: el lector no tiene multas actuales o el lector adeudar� una multa pendiente, a la cual se le extender� la fecha del final de la multa
					if(!(_lector.estaMultado())) {
						Multa nuevaMulta = new Multa(_lector,diasPasados);
						listaMultas.add(nuevaMulta);
					}
					else {
						for (int j = 0; j < listaMultas.size(); j++) {
							Multa campoMulta = listaMultas.get(j);
							if (campoMulta.getLector() == _lector) {
								campoMulta.extenderMulta(diasPasados-30);
							}
						}
					}
				}
				_lector.devuelveLibro(i);
				_copia.cambiarEstado("en la biblioteca");
				_copia.getLibroPerteneciente().enlistarDisponible(_copia);
 			}
		}
		if (!estaCopia) {
			throw new CopiaLibroException("La copia ingresada no fu� prestada al lector.");
		}
	}
	
	public void sacarMulta(Lector _lector) {
		//Tuve dudas de desarrollo a la hora de implementar esta funci�n, a la hora de pensar en "sacarMulta" por lo general se podr�a pensar que se podr�a sacar la multa si se cumple la fecha estimada, pero quiz�s el due�o de la biblioteca prefiera tener control total de cuando "sacarle la multa a alguien" sin necesidad de esperar el tiempo, quiz�s por un financiamiento de la multa o por alg�n motivo distinto. Decid� en dejarlo como condici�n para poder "sacar la multa" el cumplir la fecha estimada.
		for (int i = 0; i < listaMultas.size(); i++) {
			Multa campo = listaMultas.get(i);
			if (campo.getLector() == _lector) {
				if (new Date().getTime()>campo.getFinalMulta().getTime()) {
					campo.deshacerMulta();
					listaMultas.remove(i);
					break;
				}
			}
		}
	}
	
	public void mostrarStock() {
		//Recorro cada elemento en la lista libros y digo cuantas copias tiene disponibles y totales.
		for (int i = 0; i < libros.size();i++) {
			Libro libro = libros.get(i);
			System.out.println("Del libro: "+libro.getNombre()+" hay: "+libro.enumerarDisponibles()+" copias disponibles, y: "+libro.enumerarCopias()+" copias totales.");
		}
		System.out.println();
	}
	
	public List<Libro> devolverListaLibros(){
		return libros;
	}
	
	public void repararCopia(Copia _copia) throws CopiaLibroException, CopiaIncorrectaException {
		_copia.cambiarEstado("en reparaci�n");
		_copia.getLibroPerteneciente().sacarDisponible(_copia);
	}
	
	public void demoraLibro(Libro _libro, Lector _lector) throws CopiaLibroException, CopiaIncorrectaException {
		int milisecondsByDay = 86400000;
		Prestamo prestamoLector = _lector.getPrestamoLibro(_libro);
		if ((((new Date().getTime())/milisecondsByDay - (prestamoLector.getFecha().getTime())/milisecondsByDay))>30) {
			prestamoLector.getCopia().cambiarEstado("con retraso");
		}
	}
}
