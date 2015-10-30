package br.edu.fcv.exemplo;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.edu.fcv.exemplo.exemplo01.State;

public class FirstLevel {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJavaTestPU");
	private final EntityManager entityManager = factory.createEntityManager();
	
	@Test
	public void shouldWorkWithFirstLevel() {
		entityManager.getTransaction().begin();
		State state = new State();
		state.setName("Paraná");
		entityManager.merge(state);
		entityManager.getTransaction().commit();
		
		State firstResult = entityManager.find(State.class, 1L);
		assertNotNull(firstResult);
		State secondResult = entityManager.find(State.class, 1L);
		assertNotNull(secondResult);
	}
}