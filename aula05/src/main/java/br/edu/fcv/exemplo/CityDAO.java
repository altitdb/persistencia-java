package br.edu.fcv.exemplo;

import java.util.List;

public interface CityDAO {

	void save(City city);
	
	List<City> queryNative();
	
	List<City> queryNativeWithRestriction();
	
	List<City> queryNativeJoin();
	
	List<City> queryJpql();
	
	List<City> queryJpqlWithRestriction();
	
	List<City> queryJpqlJoin();
	
	List<City> queryNamed();
	
	List<City> queryNamedWithRestriction();
	
	List<City> queryNamedJoin();
	
	List<City> queryTypedQuery();
	
	List<City> queryTypedNamedQuery();
	
	List<City> queryCriteria();
	
	List<City> queryCriteriaWithRestriction();
	
	Long queryProjection();
	
	Long queryProjectionResultTransformer();
	
}
