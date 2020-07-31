package com.projeto.service;

import java.util.List;

public interface GenericService<T,ID> {
	
	List<T> findAll();
	T save(T entity);
	T update(T entity);
	T getOne(ID id);
	T findById(ID id);
	void deleteById(ID id);


}
