package ibm.ob.repositories.impl;

import ibm.ob.repositories.GenericRepository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;



public abstract class HibernateRepositoryImpl<E> extends HibernateDaoSupport implements GenericRepository<E>{

	public HibernateRepositoryImpl(SessionFactory factory) {
	     super.setSessionFactory(factory);
	}
	
	protected abstract Class<E> entityClass();
		

	@Override
	public void delete(E persistentObj) {
		this.getRepositoryTemplate().delete(persistentObj);	
	}

	@Override
	public void deleteAll(List<E> entities) {
		this.getRepositoryTemplate().deleteAll(entities);		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> getList() {		 
		 return (List<E>) this.getRepositoryTemplate().findByCriteria(DetachedCriteria.forClass(entityClass()));
	}

	@Override
	public E get(Serializable id) {
		return (E) this.getRepositoryTemplate().get(entityClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(String propertyName, Object value) {
		
		List<E> data = (List<E>) this.getRepositoryTemplate().findByCriteria(DetachedCriteria.forClass(entityClass())
												             .add(Restrictions.eq(propertyName, value)));		
		if(data.size() == 1){
			return data.get(0);
		}		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll(String propertyName, Object value) {        
		return (List<E>) this.getRepositoryTemplate().findByCriteria(DetachedCriteria.forClass(entityClass())
													 .add(Restrictions.eq(propertyName, value)));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll(String[] propertyNames, Object[] values) {		
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass());		
		for (int i = 0; i < propertyNames.length; i++) {
			String name = propertyNames[i];
			Object value = values[i];
			criteria.add(Restrictions.eq(name, value));
		}	
		return (List<E>) this.getRepositoryTemplate().findByCriteria(criteria);			                                     
	}

	@Override
	public void save(E entityObject) {
		this.getRepositoryTemplate().saveOrUpdate(entityObject);
	}

	@Override
	public void saveAll(List<E> entities) {		
		for (E entity : entities) {
			this.getRepositoryTemplate().saveOrUpdate(entity);
		}	
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> callStoredProcedure(String alias, String[] paramNames, Object[] values) {
		
		List<T> result = (List<T>) this.getRepositoryTemplate().findByNamedParam(alias, paramNames, values);
		
		return result;
	}
	
	@Override
	public HibernateTemplate getRepositoryTemplate() {
		return this.getHibernateTemplate();
	}
	

}
