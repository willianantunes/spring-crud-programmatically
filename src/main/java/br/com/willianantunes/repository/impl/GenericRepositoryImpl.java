package br.com.willianantunes.repository.impl;

import br.com.willianantunes.repository.GenericRepository;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> 
{
	protected static final Logger logger = LoggerFactory.getLogger(GenericRepositoryImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<T> classType;
	
	@SuppressWarnings("unchecked")
	protected GenericRepositoryImpl()
	{
		this.classType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private Session getCurrentSession() 
	{
		return this.sessionFactory.getCurrentSession();
	}	
		
	@Override
	public void save(T t)
    {
    	logger.info(String.format("Salvando (%s)", t));
    	getCurrentSession().save(t);
    }	
	
	@Override
	@SuppressWarnings("unchecked")
	public T find(Long id)
    {
    	logger.debug(String.format("Lendo (%s) com o id (%s)", this.classType, id));
    	T a = (T) getCurrentSession().load(this.classType, id);
    	return a;
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<T> list()
    {
		logger.debug(String.format("Listando (%s)", this.classType));
    	return getCurrentSession().createCriteria(this.classType).list();
    }
    
	@Override
	public void saveOrUpdate(T t)
    {
    	logger.info(String.format("Salvando ou atualizado (%s)", t));
    	getCurrentSession().saveOrUpdate(t); 
    }	
	
	@Override
	public void remove(T t)
	{
		logger.info(String.format("Removendo (%s)", t));
    	getCurrentSession().delete(t);
	}

	@Override
	public void update(T t) 
	{
		logger.info(String.format("Atualizando (%s)", t));
    	getCurrentSession().update(t);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T t) 
	{
		logger.info(String.format("Mesclando (%s)", t));
		return (T) getCurrentSession().merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> findTheRange(int start, int length) 
	{
		logger.debug(String.format("Listando (%s) de (%s) até (%s)", this.classType, start, length));
		return getCurrentSession().createCriteria(classType).setFirstResult(start).setMaxResults(length).list();
	}

	@Override
	public Long totalRecords(String column) {
		logger.debug(String.format("Total de registros do model (%s)", this.classType));
		return (Long) getCurrentSession().createCriteria(classType).setProjection(Projections.countDistinct(column)).uniqueResult();
	}
}
