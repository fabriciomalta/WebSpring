package com.projeto.repository.query;

import java.util.List;
import java.util.Optional;

import com.projeto.model.Permission;
import com.projeto.model.Usuario;

public interface UsuarioQuery {
	
	Optional<Usuario> findUsuarioByEmail(String email); /// validar o e-mail cadastrado - único
	
	Optional<Usuario> loginUsuarioByEmail(String email); // para fazer o login...
	
	List<Permission> findRolePermissaoByUsuarioId(Long id);
	
	void detach(Usuario usuario);
	
		
}
