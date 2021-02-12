
public class prueba {

	public static void main(String[] args) {
		// Utilizo la main para realizar las pruebas correspondientes pedidas en el ejercicio.
		// Futuras optimizaciones de accesos, futuras pruebas, optimizaciones, arreglo de bugs y aplicación a una base de datos que no terminé por falta de tiempo vendrán en la siguiente versión.
		
		Biblioteca b = new Biblioteca();
		
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
		Copia copia6 = new Copia("prestada");
		
		b.mostrarStock();
		System.out.println();
		
		b.nuevaCopia(copia1, libro1);
		b.nuevaCopia(copia2, libro10);
		b.nuevaCopia(copia3, libro7);
		b.nuevaCopia(copia4, libro9);
		b.nuevaCopia(copia5, libro2);
		b.nuevaCopia(copia6, libro3);
		
		b.mostrarStock();
		System.out.println();
		
		b.prestarLibro(libro1, lector1);
		b.prestarLibro(libro10, lector1);
		b.prestarLibro(libro7, lector1);
		b.prestarLibro(libro9, lector2);
		b.prestarLibro(libro2, lector2);
		
		b.mostrarStock();
		
		//Concluyo que las pruebas iniciales del funcionamiento del sistema de la biblioteca funcionan correctamente y que está abierto a futuras mejoras, como mejores prácticas a la hora de realizar el código, mejoras en la seguridad de las clases (puestas en público con motivos de testeo) y posibles nuevas implementaciones.
	}

}
