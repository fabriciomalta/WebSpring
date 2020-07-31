package com.projeto.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.projeto.model.Permission;


public interface PermissionService {
	
	boolean hasPermission(Authentication usuarioLogado, Object permissao, Object escopo);
	
    List<Permission> findRolePermissaoByUsuarioId(Long id);
	

}
