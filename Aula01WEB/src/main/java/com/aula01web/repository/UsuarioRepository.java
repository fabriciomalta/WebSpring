package com.aula01web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula01web.model.Usuario;
import com.aula01web.repository.query.UsuarioQuery;

	@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioQuery
	{
	
	}
