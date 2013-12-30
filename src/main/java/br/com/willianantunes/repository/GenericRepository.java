package br.com.willianantunes.repository;

import java.util.Collection;

public interface GenericRepository<T> 
{
	void save(T t);

	T find(Long id);
	
	Collection<T> findTheRange(int start, int length);

	Collection<T> list();

	void saveOrUpdate(T t);
	
	T merge(T t);

	void remove(T t);
	
	void update(T t);
	
	Long totalRecords(String column);
}
