package com.projeto.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface LoginService {
	
	void validarEmailPassword(String email, String password);
	
	UsernamePasswordAuthenticationToken validarUsuario(UsernamePasswordAuthenticationToken token, String email,  String password);

}
