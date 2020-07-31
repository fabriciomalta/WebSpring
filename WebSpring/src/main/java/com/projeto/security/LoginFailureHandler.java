package com.projeto.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.projeto.model.Usuario;
import com.projeto.service.UsuarioService;
import com.projeto.service.exceptions.EmailUsuarioDeveSerInformadoException;
import com.projeto.service.exceptions.SenhaUsuarioDeveSerInformadaException;


@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
	
    @Autowired
	private UsuarioService usuarioService;
    
    private static final Integer TOTAL_ACESSO = 3;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String mensagem = "";
		
		if (exception instanceof EmailUsuarioDeveSerInformadoException ) {
			mensagem = exception.getMessage();
		} else if (exception instanceof SenhaUsuarioDeveSerInformadaException ) {
			mensagem = exception.getMessage();
		} else if (exception instanceof UsernameNotFoundException ) {
			mensagem = exception.getMessage();
		} else if (exception instanceof BadCredentialsException ) {
			totalAcessoInvalidoUsuario(request);
			mensagem = exception.getMessage();
		} else if (exception instanceof LockedException ) {
			mensagem = exception.getMessage();
		} else {
			mensagem = exception.getMessage();
		}
		
		request.getRequestDispatcher(String.format("/login?mensagem=%s", mensagem)).forward(request, response);
		
	}

	private void totalAcessoInvalidoUsuario(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		
		Optional<Usuario> usuario = usuarioService.loginUsuarioByEmail(email);
		
		if ( usuario.isPresent()) {
			
			if (usuario.get().getFailedLogin() + 1 > TOTAL_ACESSO ) {
				bloquearUsuario(usuario.get());
			} else {
				updateFaileAccess(usuario.get());
			}
		}
		
	}

	private void updateFaileAccess(Usuario usuario) {
		usuarioService.updateFailedAccess(usuario);
	}

	private void bloquearUsuario(Usuario usuario) {
		usuarioService.blockedUsuario(usuario);
		
	}
	
		
	
	
	

	
	

	

}
