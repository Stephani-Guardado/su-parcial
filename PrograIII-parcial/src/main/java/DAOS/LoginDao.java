package DAOS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class LoginDao {
	public List<Usuario> Login(Usuario u) {
		List<Usuario> listads = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("PrograIII");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			listads = em.createQuery("FROM Usuario AS u where u.nombre='"+u.getNombre()+"' and u.contrasenia='"+u.getContrasenia()+"'").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listads;
	}
}
