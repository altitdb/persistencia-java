package br.edu.fcv.exemplo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.edu.fcv.exemplo.exemplo03.Client;

public class TransientObject {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJavaTestPU");
	private final EntityManager entityManager = factory.createEntityManager();
	
	@Test
	public void shouldDontCreateColumnAndDontSaveValue() {
		entityManager.getTransaction().begin();
		Client client = new Client();
		client.setName("My Client");
		client.setNickname("My Nickname");
		client = entityManager.merge(client);
		entityManager.getTransaction().commit();
		assertNotNull(client);
		assertNotNull(client.getName());
		assertNull(client.getNickname());
	}
}
