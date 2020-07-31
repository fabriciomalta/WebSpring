package com.projeto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.projeto.service.LoginService;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
    private LoginService loginService;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
	
		String email = auth.getName();
		String password = auth.getCredentials().toString();
		
		loginService.validarEmailPassword(email, password);
		
		token = loginService.validarUsuario(token, email, password);
		
		return token;

	}

	
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
