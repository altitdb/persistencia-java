package br.edu.fcv.exemplo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;

@SuppressWarnings("unchecked")
public class CityDAOImpl implements CityDAO {

	private final EntityManagerFactory factory;
	private final EntityManager entityManager;
	private final Session session;

	public CityDAOImpl() {
		factory = Persistence.createEntityManagerFactory("PersistenceJavaTestPU");
		entityManager = factory.createEntityManager();
		session = (Session) entityManager.getDelegate();
	}

	public void save(City city) {
		entityManager.getTransaction().begin();
		entityManager.merge(city);
		entityManager.getTransaction().commit();
	}

	public List<City> queryNative() {
		Query query = entityManager.createNativeQuery("SELECT * FROM CITY C", City.class);
		return query.getResultList();
	}
	
	public List<City> queryNativeWithRestriction() {
		Query query = entityManager.createNativeQuery("SELECT * FROM CITY C WHERE C.NAME = :NAME", City.class);
		query.setParameter("NAME", "Curitiba");
		return query.getResultList();
	}
	
	public List<City> queryNativeJoin() {
		Query query = entityManager.createNativeQuery("SELECT * FROM CITY C INNER JOIN STATE E ON C.STATE_ID = E.STATE_ID", City.class);
		return query.getResultList();
	}

	public List<City> queryJpql() {
		Query query = entityManager.createQuery("SELECT c FROM City c", City.class);
		return query.getResultList();
	}
	
	public List<City> queryJpqlWithRestriction() {
		Query query = entityManager.createQuery("SELECT c FROM City c WHERE c.name = :NAME", City.class);
		query.setParameter("NAME", "Curitiba");
		return query.getResultList();
	}
	
	public List<City> queryJpqlJoin() {
		Query query = entityManager.createQuery("SELECT c FROM City c JOIN c.state e", City.class);
		return query.getResultList();
	}

	public List<City> queryNamed() {
		Query query = entityManager.createNamedQuery("NamedQueryCity", City.class);
		return query.getResultList();
	}
	
	public List<City> queryNamedWithRestriction() {
		Query query = entityManager.createNamedQuery("NamedQueryCityWithRestriction", City.class);
		query.setParameter("NAME", "Curitiba");
		return query.getResultList();
	}
	
	public List<City> queryNamedJoin() {
		Query query = entityManager.createNamedQuery("NamedQueryCityJoin", City.class);
		return query.getResultList();
	}

	public List<City> queryTypedQuery() {
		TypedQuery<City> typedQuery = entityManager.createQuery("SELECT c FROM City c", City.class);
		return typedQuery.getResultList();
	}
	
	public List<City> queryTypedNamedQuery() {
		TypedQuery<City> typedQuery = entityManager.createNamedQuery("NamedQueryCity", City.class);
		return typedQuery.getResultList();
	}

	public List<City> queryCriteria() {
		Criteria criteria = session.createCriteria(City.class);
		return criteria.list();
	}
	
	public List<City> queryCriteriaWithRestriction() {
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("name", "Curitiba"));
		return criteria.list();
	}
	
	@SuppressWarnings("rawtypes")
	public Long queryProjection() {
		Criteria criteria = session.createCriteria(City.class);
		ProjectionList projections = Projections.projectionList();
		projections.add(Projections.count("cityId"), "total");
		criteria.setProjection(projections);
		List list = criteria.list();
		Long total = (Long) list.iterator().next();
		return total;
	}
	
	public Long queryProjectionResultTransformer() {
		Criteria criteria = session.createCriteria(City.class);
		ProjectionList projections = Projections.projectionList();
		projections.add(Projections.count("cityId"), "total");
		criteria.setProjection(projections);
		criteria.setResultTransformer(new AliasToBeanResultTransformer(Result.class));
		List<Result> list = criteria.list();
		return list.get(0).getTotal();
	}
	
	public void close() {
		entityManager.close();
		factory.close();
	}
}
