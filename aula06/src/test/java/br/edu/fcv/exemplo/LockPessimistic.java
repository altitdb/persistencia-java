package br.edu.fcv.exemplo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.junit.Test;

import br.edu.fcv.exemplo.exemplo05.Product;

public class LockPessimistic {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJavaTestPU");
	private final EntityManager entityManager = factory.createEntityManager();
	
	@Test(expected = RollbackException.class)
	public void shouldToDoLockPessimistic() {
		entityManager.getTransaction().begin();
		Product product = new Product();
		product.setDescription("Notebook i7 for Intern");
		entityManager.merge(product);
		entityManager.getTransaction().commit();
		
		EntityManager entityManagerFirst = factory.createEntityManager();
		entityManagerFirst.getTransaction().begin();
		Product first = entityManagerFirst.find(Product.class, 1L);
		entityManagerFirst.lock(first, LockModeType.PESSIMISTIC_WRITE);
		first.setDescription("No moreeee");
		
		EntityManager entityManagerSecond = factory.createEntityManager();
		entityManagerSecond.getTransaction().begin();
		Product second = entityManagerSecond.find(Product.class, 1L);
		second.setDescription("Ohh yeaaah");
		
		entityManagerSecond.getTransaction().commit();
		
		entityManagerFirst.getTransaction().commit();
	}
}
