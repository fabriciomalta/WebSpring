package com.projeto.security;

import org.springframework.security.core.userdetails.User;

import com.projeto.model.Usuario;

public class UsuarioSistema extends User {


	private static final long serialVersionUID = 5171836960209258797L;
	
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
