package relLibro;

public class Autor {
	//Utilizo la clase Autor para organizar los distintos autores de los libros, se deberá crear primero un objeto de tipo Autor para luego darle al libro como parámetro el objeto Autor para poder crearse correctamente.
	
	private String nombre, nacionalidad, fechaNacimiento;
	
	//Constructor
	
	public Autor(String _nombre, String _nacionalidad, String _fechaNacimiento) {
		this.nombre = _nombre;
		this.nacionalidad = _nacionalidad;
		this.fechaNacimiento = _fechaNacimiento;
	}
	
	//Módulos Getters implementados
	
	public String getNombre() {
		return nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
}
