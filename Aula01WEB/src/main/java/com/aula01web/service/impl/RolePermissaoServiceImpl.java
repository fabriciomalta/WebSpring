package com.aula01web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aula01web.model.RolePermissao;
import com.aula01web.model.RolePermissaoId;
import com.aula01web.repository.RolePermissaoRepository;
import com.aula01web.service.RolePermissaoService;


@Service
@Transactional
public class RolePermissaoServiceImpl implements RolePermissaoService {

	@Autowired
	private RolePermissaoRepository rolePermissaoRepository;
		
	@Override
	public List<RolePermissao> findAll() {
		return rolePermissaoRepository.findAll();
	}

	@Override
	public RolePermissao save(RolePermissao entity) {
		rolePermissaoRepository.flush();
		return rolePermissaoRepository.save(entity);
	}

	@Override
	public RolePermissao update(RolePermissao entity) {
		return this.save(entity);
	}

	@Override
	public RolePermissao getOne(RolePermissaoId id) {
		return rolePermissaoRepository.getOne(id);
	}

	@Override
	public RolePermissao findById(RolePermissaoId id) {
		return rolePermissaoRepository.getOne(id);
	}

	@Override
	public void deleteById(RolePermissaoId id) {
	    rolePermissaoRepository.deleteById(id);	
	}

	//@Override
	//public List<RolePermissao> findRolePermissaoEscopoFiltro(RolePermissaoFiltro rolePermissaoFiltro) {
	//	return rolePermissaoRepository.findRolePermissaoEscopoFiltro(rolePermissaoFiltro);
	//}

}