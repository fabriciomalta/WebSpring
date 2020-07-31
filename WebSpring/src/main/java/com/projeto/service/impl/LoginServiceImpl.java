package com.projeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.projeto.model.Usuario;
import com.projeto.security.UsuarioSistema;
import com.projeto.service.LoginService;
import com.projeto.service.UsuarioService;
import com.projeto.service.exceptions.EmailUsuarioDeveSerInformadoException;
import com.projeto.service.exceptions.SenhaUsuarioDeveSerInformadaException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UsernamePasswordAuthenticationToken validarUsuario(UsernamePasswordAuthenticationToken token, String email, String password) {
		Optional<Usuario> usuario = usuarioService.loginUsuarioByEmail(email);
		
		if (!usuario.isPresent()) {
			throw new UsernameNotFoundException("Usuário não está cadastrado!");
		}
		
		if ( email.equals(usuario.get().getEmail()) && usuario.get().isAtivo() == Boolean.FALSE ) {
			throw new LockedException("Usuário bloqueado no sistema!");
		}
		
		if ( email.equals(usuario.get().getEmail()) && BCrypt.checkpw(password, usuario.get().getPassword())) {
			token = new UsernamePasswordAuthenticationToken(new UsuarioSistema(usuario.get()), 
																usuario.get().getPassword(),
																usuario.get().getAuthorities());
		} else {
			throw new BadCredentialsException("A Senha informada é inválida!");
		}
		return token;
	}
	

	@Override
	public void validarEmailPassword(String email, String password) {
		if ("".equals(email)) {
			throw new EmailUsuarioDeveSerInformadoException("O E-mail do Usuário deve ser informado!");
		}
		
		if ("".equals(password)) {
			throw new SenhaUsuarioDeveSerInformadaException("A Senha do usuário deve ser informada!");
		}
	}

}
