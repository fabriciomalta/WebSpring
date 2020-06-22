package com.aula01web.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.aula01web.model.Usuario;
import com.aula01web.repository.query.UsuarioQuery;

public class UsuarioRepositoryQueryImpl implements UsuarioQuery
	{
	
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public Optional<Usuario> findUsuarioByEmail(String email) {
			
			boolean ativo = Boolean.TRUE;
			
			TypedQuery<Usuario> query = entityManager
					.createQuery("SELECT u FROM Usuario u "
							   + "WHERE "
							   + "u.email =:email "
							   + "AND "
							   + "u.ativo =:ativo", Usuario.class);
			
			return query.setParameter("email", email)
						.setParameter("ativo", ativo)
						.setMaxResults(1)
						.getResultList()
						.stream()
						.findFirst();
		}

		
	
	}
