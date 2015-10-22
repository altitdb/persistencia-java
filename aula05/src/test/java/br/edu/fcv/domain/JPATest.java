package br.edu.fcv.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.fcv.exemplo.City;
import br.edu.fcv.exemplo.CityDAO;
import br.edu.fcv.exemplo.CityDAOImpl;
import br.edu.fcv.exemplo.State;

public class JPATest {

	private static final CityDAO DAO = new CityDAOImpl();

	@BeforeClass
	public static void before() {
		State state = new State();
		state.setName("Paraná");
		City city = new City();
		city.setName("Maringá");
		city.setState(state);
		DAO.save(city);
	}

	@Test
	public void shouldUseQueryNative() {
		List<City> cities = DAO.queryNative();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryNativeWithRestriction() {
		List<City> cities = DAO.queryNativeWithRestriction();
		assertEquals(0, cities.size());
	}
	
	@Test
	public void shouldUseQueryNativeJoin() {
		List<City> cities = DAO.queryNativeJoin();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryJpql() {
		List<City> cities = DAO.queryJpql();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryJpqlWithRestriction() {
		List<City> cities = DAO.queryJpqlWithRestriction();
		assertEquals(0, cities.size());
	}
	
	@Test
	public void shouldUseQueryJpqlJoin() {
		List<City> cities = DAO.queryJpqlJoin();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryNamed() {
		List<City> cities = DAO.queryNamed();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryNamedWithRestriction() {
		List<City> cities = DAO.queryNamedWithRestriction();
		assertEquals(0, cities.size());
	}
	
	@Test
	public void shouldUseQueryNamedJoin() {
		List<City> cities = DAO.queryNamedJoin();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryTypedQuery() {
		List<City> cities = DAO.queryTypedQuery();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryTypedNamedQuery() {
		List<City> cities = DAO.queryTypedNamedQuery();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryCriteria() {
		List<City> cities = DAO.queryCriteria();
		assertEquals(1, cities.size());
	}
	
	@Test
	public void shouldUseQueryCriteriaWithRestriction() {
		List<City> cities = DAO.queryCriteriaWithRestriction();
		assertEquals(0, cities.size());
	}
	
	@Test
	public void shouldUseQueryProjection() {
		Long total = DAO.queryProjection();
		assertSame(1L, total);
	}
	
	@Test
	public void shouldUseQueryProjectionResultTransformer() {
		Long total = DAO.queryProjectionResultTransformer();
		assertSame(1L, total);
	}
	
}