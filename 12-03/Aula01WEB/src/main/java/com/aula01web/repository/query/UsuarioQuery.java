package com.aula01web.repository.query;

import java.util.Optional;
import com.aula01web.model.Usuario;
public interface UsuarioQuery 
{
	
	Optional<Usuario> findUsuarioByEmail(String email);
}
