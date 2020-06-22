package com.aula01web.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.aula01web.model.Usuario;

public class UsuarioSistema extends User {

	private Usuario usuario;
	public UsuarioSistema(Usuario usuario) {
		super(usuario.getUsername(),
				usuario.getPassword(),
				usuario.isEnabled(), 
				usuario.isAccountNonExpired(),
				usuario.isAccountNonLocked(),
				usuario.isCredentialsNonExpired(),
				usuario.getAuthorities());
		
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
