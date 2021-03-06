package com.aula01web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aula01web.model.Usuario;
import com.aula01web.repository.query.UsuarioQuery;

	@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioQuery
	{
		
		@Query("SELECT distinct u FROM Usuario u LEFT JOIN FETCH u.roles")
		List<Usuario> findAllUsuarios();
		
	}
