package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.RolePermissao;
import com.projeto.model.RolePermissaoId;
import com.projeto.repository.RolePermissaoRepository;
import com.projeto.repository.filtros.RolePermissaoFiltro;
import com.projeto.service.RolePermissaoService;

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

	@Override
	public List<RolePermissao> findRolePermissaoEscopoFiltro(RolePermissaoFiltro rolePermissaoFiltro) {
		return rolePermissaoRepository.findRolePermissaoEscopoFiltro(rolePermissaoFiltro);
	}

}
