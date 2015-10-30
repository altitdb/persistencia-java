package br.edu.fcv.exemplo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.edu.fcv.exemplo.exemplo02.Account;

public class SecondLevel {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJavaTestPU");
	private final EntityManager entityManager = factory.createEntityManager();
	
	@Test
	public void shouldWorkWithSecondLevel() {
		entityManager.getTransaction().begin();
		Account account = new Account();
		account.setName("altitdb");
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		
		Cache cache = factory.getCache();
        Boolean firstResult = cache.contains(Account.class, 1L);
        assertTrue(firstResult);
        cache.evict(Account.class);
        Boolean secondResult = cache.contains(Account.class, 1L);
        assertFalse(secondResult);
	}
}