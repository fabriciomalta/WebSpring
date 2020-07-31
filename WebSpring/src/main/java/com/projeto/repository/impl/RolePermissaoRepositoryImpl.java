package com.projeto.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.projeto.model.Escopo;
import com.projeto.model.Permissao;
import com.projeto.model.Role;
import com.projeto.model.RolePermissao;
import com.projeto.repository.filtros.RolePermissaoFiltro;
import com.projeto.repository.query.RolePermissaoQuery;

public class RolePermissaoRepositoryImpl implements RolePermissaoQuery{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<RolePermissao> findRolePermissaoEscopoFiltro(RolePermissaoFiltro rolePermissaoFiltro) {
		
		TypedQuery<RolePermissao> query = null;

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RolePermissao> cq = cb.createQuery(RolePermissao.class);
		Root<RolePermissao> fromRolePermissao = cq.from(RolePermissao.class);
		
		if (!StringUtils.isEmpty(rolePermissaoFiltro.getRoleNome())) {
			Join<RolePermissao, Role> rolePermissao_role = fromRolePermissao.join("role_id");
			cq.where(cb.like(cb.lower(rolePermissao_role.get("nome")), "%"+rolePermissaoFiltro.getRoleNome()));
		} else if (!StringUtils.isEmpty(rolePermissaoFiltro.getPermissaoNome())) {
			Join<RolePermissao, Permissao> rolePermissao_permissao = fromRolePermissao.join("permissao_id");
			cq.where(cb.like(cb.lower(rolePermissao_permissao.get("nome")), "%"+rolePermissaoFiltro.getPermissaoNome()));
		} else if (!StringUtils.isEmpty(rolePermissaoFiltro.getEscopoNome())) {
			Join<RolePermissao, Escopo> rolePermissao_escopo = fromRolePermissao.join("escopo_id");
			cq.where(cb.like(cb.lower(rolePermissao_escopo.get("nome")), "%"+rolePermissaoFiltro.getEscopoNome()));
		} else {
			cq.select(fromRolePermissao);
		}
		
		query = entityManager.createQuery(cq);
			
		return query.getResultList();
	}
	
	

	

}
