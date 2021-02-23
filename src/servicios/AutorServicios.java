package servicios;
import java.util.ArrayList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import persistencia.AutorDAO;
import relLibro.Autor;

@WebService 
public class AutorServicios {
	
	@WebMethod(operationName = "agregarAutorWS")
	public void agregarAutor(@WebParam(name = "Autor") Autor a) {
		AutorDAO dao = new AutorDAO();
		try {
			dao.agregarAutor(a);
		}catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	@WebMethod(operationName = "consultarAutoresWS")
	public ArrayList<Autor> mostrarAutores() {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		try {
			autores = mostrarAutores();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return autores;	
	}
}
