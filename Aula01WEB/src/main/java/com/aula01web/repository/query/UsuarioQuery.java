package com.aula01web.repository.query;

import java.util.Optional;
import com.aula01web.model.Usuario;
public interface UsuarioQuery 
{
	
	Optional<Usuario> findUsuarioByEmail(String email); //Validar o email cadastrado, único
	
	//Optional<Usuario> loginUsuarioByEmail(String email); // Pra autenticar o login
}
