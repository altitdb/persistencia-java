package br.edu.fcv.exemplo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.junit.Test;

import br.edu.fcv.exemplo.exemplo04.UserApp;

public class LockOptimistic {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJavaTestPU");
	private final EntityManager entityManager = factory.createEntityManager();
	
	@Test(expected = RollbackException.class)
	public void shouldToDoLockOptimistic() {
		entityManager.getTransaction().begin();
		UserApp user = new UserApp();
		user.setLogin("mylogin");
		user.setPassword("123456");
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		
		EntityManager entityManagerFirst = factory.createEntityManager();
		entityManagerFirst.getTransaction().begin();
		UserApp first = entityManagerFirst.find(UserApp.class, 1L);
		first.setPassword("12345678");
		
		EntityManager entityManagerSecond = factory.createEntityManager();
		entityManagerSecond.getTransaction().begin();
		UserApp second = entityManagerSecond.find(UserApp.class, 1L);
		second.setLogin("otherlogin");
		
		entityManagerSecond.getTransaction().commit();
		
		entityManagerFirst.getTransaction().commit();
	}
	
}
