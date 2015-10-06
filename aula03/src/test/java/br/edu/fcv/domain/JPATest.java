package br.edu.fcv.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JPATest {

	@Test
	public void deveriaMapearTodasAsClasses() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PersistenceJavaTestPU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.close();
		factory.close();
	}
}