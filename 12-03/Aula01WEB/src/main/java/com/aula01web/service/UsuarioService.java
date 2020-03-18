package com.aula01web.service;

import java.util.Optional;

import com.aula01web.model.Usuario;

public interface UsuarioService extends GenericService<Usuario, Long> 
	{

	Optional<Usuario> findUsuarioByEmail(String email);
	//public Optional<Usuario> findUsuarioByEmail(String email);
	}
