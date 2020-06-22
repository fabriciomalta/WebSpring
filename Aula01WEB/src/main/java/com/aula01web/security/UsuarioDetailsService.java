package com.aula01web.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aula01web.model.Usuario;
import com.aula01web.service.UsuarioService;

@Service
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Usuario> usuario = usuarioService.findUsuarioByEmail(email);
		
		if(usuario.isPresent()) {
			throw new UsernameNotFoundException("Usuario não encontrado!" + email);
		}
		return new UsuarioSistema(usuario.get());
	}

}
