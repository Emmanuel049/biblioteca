package persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import jakarta.jws.WebService;
import relLibro.Autor;

public class AutorDAO {
	
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ejsHibernate");
	EntityManager em = managerFactory.createEntityManager();
	
	public void agregarAutor(Autor a) throws Exception{
		
		
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		em.persist(a);
		tran.commit();
		em.close();
	}
	
public List<Autor> mostrarAutores(){
	EntityManager em = managerFactory.createEntityManager();
	Autor autor = em.find(Autor.class, "nombre");
	return (em.createQuery("SELECT a FROM Autor a").getResultList());
	}
}
