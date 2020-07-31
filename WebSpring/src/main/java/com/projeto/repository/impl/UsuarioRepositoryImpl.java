package com.projeto.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.projeto.model.Permission;
import com.projeto.model.Usuario;
import com.projeto.repository.query.UsuarioQuery;

public class UsuarioRepositoryImpl implements UsuarioQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<Usuario> findUsuarioByEmail(String email) {
		
		TypedQuery<Usuario> query = entityManager
				.createQuery("SELECT u FROM Usuario u "
						   +" LEFT JOIN FETCH u.roles "
						   + "WHERE "
						   + "u.email =:email ", Usuario.class);
		
		return query.setParameter("email", email)
					.setMaxResults(1)
					.getResultList()
					.stream()
					.findFirst();
	}


	@Override
	public Optional<Usuario> loginUsuarioByEmail(String email) {
		
		TypedQuery<Usuario> query = entityManager
				.createQuery("SELECT u FROM Usuario u "
						   + "LEFT JOIN FETCH u.roles "
						   + "WHERE "
						   + "u.email =:email ", Usuario.class);
		
		return query.setParameter("email", email)
					.setMaxResults(1)
					.getResultList()
					.stream()
					.findFirst();
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> findRolePermissaoByUsuarioId(Long id) {
		

		List<Permission> lista = new ArrayList<>();
		
		Query query = entityManager.createNativeQuery("select "
				+ " 	tab_role.role_name, "
				+ " 	tab_permissao.permissao_nome, "
				+ "		tab_escopo.escopo_nome " 
        		+ " from "
        		+ " 	tab_usuario "
        		+ " inner join "
        		+ "		tab_usuario_role on tab_usuario_role.USUARIO_ID = tab_usuario.USUARIO_ID "
        		+ " inner join "
        		+ "		tab_role on tab_role.role_id = tab_usuario_role.ROLE_ID"
        		+ " inner join "
        		+ "		tab_role_permissao on tab_role_permissao.role_id = tab_role.role_id "
        		+ " inner join "
        		+ " 	tab_permissao on tab_role_permissao.permissao_id = tab_permissao.permissao_id "
        		+ " inner join "
        		+ " 	tab_escopo on tab_role_permissao.escopo_id = tab_escopo.escopo_id"
        		+ " where "
        		+ " 	tab_usuario.USUARIO_ID=:id ").setParameter("id", id);
	  	
	
		List<Object[]> mylista = query.getResultList();
		
		for (int i = 0 ; i < mylista.size(); i++) {
			Permission permission = new Permission();
			permission.setRole(mylista.get(i)[0].toString());
			permission.setPermissao(mylista.get(i)[1].toString());
			permission.setEscopo(mylista.get(i)[2].toString());
			lista.add(permission);
		}
		
	
		return lista;
		
	}


	@Override
	public void detach(Usuario usuario) {
		entityManager.detach(usuario);
	}


	

}














