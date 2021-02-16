package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import biblioteca.Biblioteca;
import excepciones.ContieneLibroException;
import excepciones.CopiaIncorrectaException;
import excepciones.CopiaLibroException;
import excepciones.CopiasInsuficientesException;
import excepciones.LectorMultadoException;
import excepciones.LibroYaPrestadoException;
import excepciones.PrestamosExcedidosException;
import excepciones.TipoException;
import relLector.Lector;
import relLector.Prestamo;
import relLibro.Autor;
import relLibro.Copia;
import relLibro.Libro;

class PruebasUnitariasJunit {

	@Test
	void test() throws TipoException, ContieneLibroException, CopiasInsuficientesException, LectorMultadoException, PrestamosExcedidosException, CopiaLibroException, CopiaIncorrectaException, LibroYaPrestadoException{
		
		Biblioteca b = new Biblioteca();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 1 Asignaciones
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Autor autor1 = new Autor("Marcos","Argentino","19/04/1980");
		Autor autor2 = new Autor("David","Brasilero","28/01/1994");
		Autor autor3 = new Autor("Marianella","China","08/10/1982");
		Autor autor4 = new Autor("Gimena","Española","03/02/1996");
		Libro libro1 = new Libro("Matematica", "ensayo", "Estrada", 2005, autor1);
		Libro libro2 = new Libro("Unicos", "novela", "Indio", 2011, autor2);
		Libro libro3 = new Libro("China", "poesia", "Catalan", 2015, autor3);
		Libro libro4 = new Libro("Programacion web Avanzada", "ensayo", "Estrada", 2017, autor4);
		Libro libro5 = new Libro("Sabalero: una leyenda", "teatro", "Planeta", 2014, autor2);
		Libro libro6 = new Libro("Operaciones Financieras I", "ensayo", "Eudeba", 2018, autor4);
		Libro libro7 = new Libro("7 Días", "poesia", "Penguin Random House", 2016, autor3);
		Libro libro8 = new Libro("Los Miserables", "teatro", "Penguin Random House", 2020, autor1);
		Libro libro9 = new Libro("Amor Imposible", "novela", "Ophelia", 2019, autor3);
		Libro libro10 = new Libro ("Covid 19: Investigacion", "ensayo", "Limonero", 2021, autor4);
		
		
		b.agregarLibro(libro1);
		b.agregarLibro(libro2);
		b.agregarLibro(libro3);
		b.agregarLibro(libro4);
		b.agregarLibro(libro5);
		b.agregarLibro(libro6);
		b.agregarLibro(libro7);
		b.agregarLibro(libro8);
		b.agregarLibro(libro9);
		b.agregarLibro(libro10);
		
		Lector lector1 = new Lector("Mauro");
		Lector lector2 = new Lector("Jazmin");
		
		Copia copia1 = new Copia("en la biblioteca");
		Copia copia2 = new Copia("en la biblioteca");
		Copia copia3 = new Copia("en la biblioteca");
		Copia copia4 = new Copia("en la biblioteca");
		Copia copia5 = new Copia("en la biblioteca");
		Copia copia6 = new Copia("en reparación");
		
		
		b.nuevaCopia(copia1, libro1);
		b.nuevaCopia(copia2, libro10);
		b.nuevaCopia(copia3, libro7);
		b.nuevaCopia(copia4, libro9);
		b.nuevaCopia(copia5, libro2);
		b.nuevaCopia(copia6, libro3);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 1 Pruebas Unitarias
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List<Libro> lista1 = new ArrayList<Libro>();
		lista1.add(libro1);
		lista1.add(libro2);
		lista1.add(libro3);
		lista1.add(libro4);
		lista1.add(libro5);
		lista1.add(libro6);
		lista1.add(libro7);
		lista1.add(libro8);
		lista1.add(libro9);
		lista1.add(libro10);
		
		assertEquals("Marcos",autor1.getNombre());
		assertEquals("Brasilero",autor2.getNacionalidad());
		assertEquals("08/10/1982",autor3.getFechaNacimiento());
		assertEquals("Matematica",libro1.getNombre());
		assertEquals("novela",libro2.getTipo());
		assertEquals("Catalan",libro3.getEditorial());
		assertEquals(2017,libro4.getAño());
		assertEquals(autor2,libro5.getAutor());
		assertEquals(lista1,b.devolverListaLibros());
		assertEquals("Mauro",lector1.getNombre());
		assertEquals(1,lector2.getId());
		assertEquals(false,lector1.estaMultado());
		assertEquals("en reparación",copia6.getEstado());
		
		//Con esto compruebo que la mayoría de las asignaciones a cada clase se asignan correctamente en las pruebas con las llamadas a los métodos correspondientes.
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 2 Asignaciones
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		b.prestarLibro(libro1, lector1);
		b.prestarLibro(libro10, lector1);
		b.prestarLibro(libro7, lector1);
		b.prestarLibro(libro9, lector2);
		b.prestarLibro(libro2, lector2);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 2 Pruebas Unitarias
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List<Copia> lista2 = new ArrayList<Copia>();
		lista2.add(copia1);
		lista2.add(copia2);
		lista2.add(copia3);
		
		List<Copia> lista3 = new ArrayList<Copia>();
		lista3.add(copia4);
		lista3.add(copia5);
		
		assertEquals(lector1.getListaCopiasPrestadas(),lista2);
		assertEquals(lector2.getListaCopiasPrestadas(),lista3);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//Con esto compruebo que los préstamos se guardan en la lista de préstamos en la clase Lector, y con el método getListaCopiasPrestadas() puedo devolver una lista de copias con los elementos copia asignados a cada préstamos en la lista de préstamos
		
		
		b.mostrarStock();
		
		//Con esto termino de pasar todas las pruebas mandadas como necesarias y por último imprimo en consola los stocks disponibles y totales de cada libro en la biblioteca.
	}
}
