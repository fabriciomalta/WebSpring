package com.projeto.service;

import java.util.List;

import com.projeto.model.RolePermissao;
import com.projeto.model.RolePermissaoId;
import com.projeto.repository.filtros.RolePermissaoFiltro;

public interface RolePermissaoService extends GenericService<RolePermissao, RolePermissaoId>{

	List<RolePermissao> findRolePermissaoEscopoFiltro(RolePermissaoFiltro rolePermissaoFiltro);
	
}
