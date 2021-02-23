package relLibro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Autores") public class Autor {
	//Utilizo la clase Autor para organizar los distintos autores de los libros, se deberá crear primero un objeto de tipo Autor para luego darle al libro como parámetro el objeto Autor para poder crearse correctamente.
	
	@Column (name="nombre") @Id String nombre;
	@Column (name="nacionalidad") String nacionalidad;	
	@Column (name="fecha_nacimiento") String fechaNacimiento;
	
	//Constructor
	
	public Autor() {
		this.nombre = null;
		this.nacionalidad = null;
		this.fechaNacimiento = null;
		

	}
	
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
	
	//Módulos Setters implementados
	
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	public void setNacionalidad(String _nacionalidad) {
		this.nacionalidad = _nacionalidad;
	}
	
	public void setFechaNacimiento(String _fechaNacimiento) {
		this.fechaNacimiento = _fechaNacimiento;
	}
}
