package com.aula01web.service;

import java.util.List;
import java.util.Optional;

import com.aula01web.model.Usuario;

public interface GenericService<T, ID> {

	List<T> findAll();
	T save(T entity);
	T update(T entity);
	T getOne(ID id);
	void deleteById(ID id);
	T findById(ID id);
	Optional<Usuario> findUsuarioByEmail(String email);
	
}
