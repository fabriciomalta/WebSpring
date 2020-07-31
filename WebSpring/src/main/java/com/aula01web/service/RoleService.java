package com.aula01web.service;

import org.springframework.stereotype.Service;

import com.aula01web.model.Role;
@Service
public interface RoleService  extends GenericService<Role, Long>{
	Role findRole(String role);
}
