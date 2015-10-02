package br.edu.fcv.exemplo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDAOImpl implements StudentDAO {

	private final EntityManagerFactory factory;
	private final EntityManager entityManager;

	public StudentDAOImpl() {
		factory = Persistence
				.createEntityManagerFactory("PersistenceJavaPU");
		entityManager = factory.createEntityManager();
	}

	public void save(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}

	public void update(Student student) {
		entityManager.getTransaction().begin();
		entityManager.merge(student);
		entityManager.getTransaction().commit();
	}

	public void delete(Student student) {
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		return entityManager.createNativeQuery("SELECT * FROM STUDENT", Student.class).getResultList();
	}

	public void close() {
		entityManager.close();
		factory.close();
	}
}
