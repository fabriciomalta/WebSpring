package com.projeto.repository.query;

import java.util.List;

import com.projeto.model.RolePermissao;
import com.projeto.repository.filtros.RolePermissaoFiltro;

public interface RolePermissaoQuery {

	List<RolePermissao> findRolePermissaoEscopoFiltro(RolePermissaoFiltro rolePermissaoFiltro);
	
	
}
