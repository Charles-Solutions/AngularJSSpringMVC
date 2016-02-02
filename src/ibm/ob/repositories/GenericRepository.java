package ibm.ob.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;


public abstract interface GenericRepository<E> {	

	void save(E entityObject);

	void saveAll(List<E> entities);

	E get(Serializable id);	
	
	E get(String propertyName, Object value);
	
	List<E> getAll(String propertyName, Object value);
	
	List<E> getAll(String[] propertyNames, Object[] values);

	void delete(E persistentObj);

	void deleteAll(List<E> entities);

	List<E> getList();
	
	<T> List<T> callStoredProcedure(String alias, String[] paramNames, Object[] values);
	
	HibernateTemplate getRepositoryTemplate();
}
