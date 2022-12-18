import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Processzor;
import model.Vga;

public class Test {

	public static void main(String[] args) {
		System.out.println("Teszt start...");
		EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA");
		EntityManager m = f.createEntityManager();
		EntityTransaction t = m.getTransaction();
		
		t.begin();
		// új rekord létrehozása
		
		Processzor p = new Processzor();
		p.setNev("testproc");
		p.setAr(15000);
		
		m.persist(p);
		t.commit();
		
		System.out.println("Teszt stop...");
	}

}
