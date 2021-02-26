package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
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
import relLector.Multa;
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
		
		Libro libro11 = new Libro ("Resputin", "leyenda", "redaktsionnaya", 2021, autor3);	//Cree un libro con un tipo distinto para probar que pasa si no se crea un tipo no deseado, si bien el libro se crea tirará error más adelante cuando lo agrege a la biblioteca
		Libro libro12 = new Libro ("Tadeo", "novela", "Penguin Random House", 2021, autor1);
		
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
		
		//b.agregarLibro(libro11);	#El libro al ser agregado a la biblioteca explota con la excepción correspondiente, esto demuestra que si se ingresa un tipo no deseado de libro no podrá agregarse a la biblioteca, se puede demostrar descomentando esta línea de código
		b.agregarLibro(libro12);
		
		Lector lector1 = new Lector("Mauro");
		Lector lector2 = new Lector("Jazmin");
		Lector lector3 = new Lector("Lucas");
		Lector lector4 = new Lector("Marta");
		
		
		Copia copia1 = new Copia("en la biblioteca");
		Copia copia2 = new Copia("en la biblioteca");
		Copia copia3 = new Copia("en la biblioteca");
		Copia copia4 = new Copia("en la biblioteca");
		Copia copia5 = new Copia("en la biblioteca");
		Copia copia6 = new Copia("en reparación");
		
		Copia copia7 = new Copia("en la biblioteca");
		Copia copia8 = new Copia("en la biblioteca");
		Copia copia9 = new Copia("en la biblioteca");
		Copia copia10 = new Copia("en la biblioteca");
		Copia copia11 = new Copia("en la biblioteca");
		Copia copia12 = new Copia("en la biblioteca");
		Copia copia13 = new Copia("en la biblioteca");
		
		
		b.nuevaCopia(copia1, libro1);
		b.nuevaCopia(copia2, libro10);
		b.nuevaCopia(copia3, libro7);
		b.nuevaCopia(copia4, libro9);
		b.nuevaCopia(copia5, libro2);
		b.nuevaCopia(copia6, libro3);
		
		b.nuevaCopia(copia7, libro1);
		b.nuevaCopia(copia8, libro8);
		b.nuevaCopia(copia9, libro6);
		b.nuevaCopia(copia10, libro10);
		b.nuevaCopia(copia11, libro4);
		b.nuevaCopia(copia12, libro5);
		b.nuevaCopia(copia13, libro2);
		
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
		lista1.add(libro12);
		
		assertEquals("Marcos",autor1.getNombre());
		assertEquals("Brasilero",autor2.getNacionalidad());
		assertEquals("08/10/1982",autor3.getFechaNacimiento());
		assertEquals("Matematica",libro1.getNombre());
		assertEquals("novela",libro2.getTipo());
		assertEquals("Catalan",libro3.getEditorial());
		assertEquals(2017,libro4.getAño());
		assertEquals(autor2,libro5.getAutor());
		assertEquals(lista1,b.devolverListaLibros());		//Con esta línea de código compruebo que se asigna una lista de libros dentro de la clase Biblioteca donde se almacenan todos los libros que tiene la biblioteca
		assertEquals("Mauro",lector1.getNombre());
		assertEquals(1,lector2.getId());
		assertEquals(false,lector1.estaMultado());
		assertEquals("en reparación",copia6.getEstado());
		
		assertEquals("en la biblioteca",copia12.getEstado());
		b.desenlistarLibro(libro12);
		//b.desenlistarLibro(libro11);	#Acá pruebo que pasa cuando se desenlista un libro de una biblioteca cuando el libro no está en dicha biblioteca, aparece la excepción correspondiente
		
		assertEquals(libro1.getId(),0);
		assertEquals(libro2.getId(),1);
		assertEquals(libro3.getId(),2);
		assertEquals(libro4.getId(),3);
		assertEquals(libro5.getId(),4);
		assertEquals(libro6.getId(),5);
		assertEquals(libro7.getId(),6);
		assertEquals(libro8.getId(),7);
		assertEquals(libro9.getId(),8);
		assertEquals(libro10.getId(),9);
		assertEquals(libro11.getId(),10);
		assertEquals(libro12.getId(),11);
		
		assertEquals(copia1.getId(),0);
		assertEquals(copia2.getId(),1);
		assertEquals(copia3.getId(),2);
		assertEquals(copia4.getId(),3);
		assertEquals(copia5.getId(),4);
		assertEquals(copia6.getId(),5);
		assertEquals(copia7.getId(),6);
		assertEquals(copia8.getId(),7);
		assertEquals(copia9.getId(),8);
		assertEquals(copia10.getId(),9);
		assertEquals(copia11.getId(),10);
		assertEquals(copia12.getId(),11);
		assertEquals(copia13.getId(),12);
		
		assertEquals(lector1.getId(),0);
		assertEquals(lector2.getId(),1);
		assertEquals(lector3.getId(),2);
		assertEquals(lector4.getId(),3);
		
		//Con esto compruebo que la mayoría de las asignaciones a cada clase se asignan correctamente en las pruebas con las llamadas a los métodos correspondientes.
		
		b.mostrarStock();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 2 Asignaciones
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		b.prestarLibro(libro1, lector1);
		b.prestarLibro(libro10, lector1);
		b.prestarLibro(libro7, lector1);
		b.prestarLibro(libro9, lector2);
		b.prestarLibro(libro2, lector2);
		
		b.prestarLibro(libro8, lector3);
		b.prestarLibro(libro6, lector3);
		b.prestarLibro(libro10, lector3);
		//b.prestarLibro(libro4, lector3);		#Descomentando esta línea de código podemos comprobar que funciona el límite de 3 préstamos máximos
		
		//b.prestarLibro(libro2, lector2);		#Acá compruebo que no se puede entregar 2 veces el mismo libro a la misma persona si ya posee una copia del mismo libro en su poder
		//b.prestarLibro(libro3, lector1);		#Acá muestro un poco el algoritmo de mi programa, al tener 3 copias entregadas a un lector y querer entregar otra, antes que cualquier otra excepción va a mostrarse que el lector ya tiene 3 libros, y la operación acaba ahí
		//b.prestarLibro(libro3, lector2);		#En esta línea muestro que una copia en reparación no cuenta como "copia disponible", por lo tanto se toma como si "no estuviera"
		//b.repararCopia(copia13);		#Para reparar una copia el mismo debe estar en la biblioteca, y vinculado a un libro, de lo contrario no será posible "mandarlo a reparar"
		copia13.cambiarEstado("en reparación");		//A pesar de no estar vinculada a nada puede cambiarse el estado de la copia, esto podría referir a una copia en blanco.
		//copia13.cambiarEstado("en reparacion");		#El código es estricto con que se ingrese exactamente "en reparación", "en la biblioteca", "prestada" o "en retraso" para que tome la copia, sino tirará una excepción
		
		
		Prestamo prestamo1 = lector1.getPrestamoLibro(libro1);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 2 Pruebas Unitarias
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List<Copia> lista2 = new ArrayList<Copia>();
		lista2.add(copia7);
		lista2.add(copia10);
		lista2.add(copia3);
		
		List<Copia> lista3 = new ArrayList<Copia>();
		lista3.add(copia4);
		lista3.add(copia13);
		
		List<Copia> lista4 = new ArrayList<Copia>();
		lista4.add(copia8);
		lista4.add(copia9);
		lista4.add(copia2);
		
		assertEquals(lector1.getListaCopiasPrestadas(),lista2);
		assertEquals(lector2.getListaCopiasPrestadas(),lista3);
		assertEquals(lector3.getListaCopiasPrestadas(),lista4);
		
		List lista5 = new ArrayList();
		lista5.add(prestamo1.getFecha().getYear());
		lista5.add(prestamo1.getFecha().getMonth());
		lista5.add(prestamo1.getFecha().getDate());
		
		List lista6 = new ArrayList();
		lista6.add(new Date().getYear());
		lista6.add(new Date().getMonth());
		lista6.add(new Date().getDate());
		
		assertEquals(lista5,lista6);	//En esta línea demuestro que el día del préstamos se asigna correctamente y se corresponde con la fecha actual
		
		assertEquals(copia12.getEstado(),"en la biblioteca");
		assertEquals(copia12.getLibroPerteneciente().tieneCopiaDisponible(copia12),true);
		b.repararCopia(copia12);
		assertEquals(copia12.getEstado(),"en reparación");	
		assertEquals(copia12.getLibroPerteneciente().tieneCopiaDisponible(copia12),false);	//Con esas líneas de código pruebo que se puede cambiar el estado de una copia y que eso repercute en que el libro que contiene a dicha copia cambie la lista de libros disponibles que contiene
		
		b.mostrarStock();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//                                   Bloque 3 Asignaciones
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		b.devolverLibro(copia7, lector1);
		//b.devolverLibro(copia4, lector1);		#Con esta línea de código verifico que no se pueda devolver una copia que no fué prestada al lector.
		Multa multa1 = new Multa(lector1,5);
		
		List lista7 = new ArrayList();
		lista7.add(multa1.getFechaMulta().getYear());
		lista7.add(multa1.getFechaMulta().getMonth());
		lista7.add(multa1.getFechaMulta().getDate());
		
		assertEquals(lista6,lista7);	//Con esta línea verifico que la fecha de la multa se asigna correctamente
		
		Date fecha1 = new Date(new Date().getYear(),new Date().getMonth(),new Date().getDate()+10);
		List lista8 = new ArrayList();
		lista8.add(fecha1.getYear());
		lista8.add(fecha1.getMonth());
		lista8.add(fecha1.getDate());
		
		List lista9 = new ArrayList();
		lista9.add(multa1.getFinalMulta().getYear());
		lista9.add(multa1.getFinalMulta().getMonth());
		lista9.add(multa1.getFinalMulta().getDate());
		
		assertEquals(lista8,lista9);	//Con esto pruebo las fechas inicial y final de la multa se asignan correctamente
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//Con esto compruebo que los préstamos se guardan en la lista de préstamos en la clase Lector, y con el método getListaCopiasPrestadas() puedo devolver una lista de copias con los elementos copia asignados a cada préstamos en la lista de préstamos
		
		
		b.mostrarStock();
		
		//Con esto termino de pasar todas las pruebas mandadas como necesarias y por último imprimo en consola los stocks disponibles y totales de cada libro en la biblioteca.
	}
}
