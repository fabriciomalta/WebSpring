package com.projeto.service;


import java.util.List;

import com.projeto.model.Role;

public interface RoleService extends GenericService<Role, Long>{
	
	Role findRole(String role);
	
	List<Role> findAllRoles();
	
	void saveUsuarioRoleAuditoria(Role role, String operacao);
	

}
