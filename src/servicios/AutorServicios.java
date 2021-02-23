package servicios;
import persistencia.AutorDAO;
import relLibro.Autor;

public class AutorServicios {
	public boolean agregarAutor(Autor a) {
		AutorDAO dao = new AutorDAO();
		
		try {
			dao.agregarAutor(a);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
