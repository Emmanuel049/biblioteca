
public class Autor {
	//Utilizo la clase Autor para organizar los distintos autores de los libros, se deberá crear primero un objeto de tipo Autor para luego darle al libro como parámetro el objeto Autor para poder crearse correctamente.
	
	String nombre, nacionalidad, fechaNacimiento;
	
	//Constructor
	
	public Autor(String _nombre, String _nacionalidad, String _fechaNacimiento) {
		nombre = _nombre;
		nacionalidad = _nacionalidad;
		fechaNacimiento = _fechaNacimiento;
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
