package com.projeto.service;


import java.util.Optional;

import com.projeto.model.Usuario;

public interface UsuarioService extends GenericService<Usuario, Long> {
	
	Optional<Usuario> findUsuarioByEmail(String email);
	
	Optional<Usuario> loginUsuarioByEmail(String email);

	void updateLoginUsuario(Usuario usuario);

	void blockedUsuario(Usuario usuario);

	void updateFailedAccess(Usuario usuario);

	
	

}
