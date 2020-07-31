package com.projeto.security;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Component;

import com.projeto.model.Usuario;
import com.projeto.service.UsuarioService;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		request.getSession().setMaxInactiveInterval(60*60);
		
		UsuarioSistema usuario_logado = (UsuarioSistema) auth.getPrincipal();
		
		
		if (!Objects.isNull(usuario_logado)) {
			persistentTokenBasedRememberMeServices.loginSuccess(request, response, auth);
		}
		
		
		updateLoginUsuario(usuario_logado.getUsuario());
		
		redirectStrategy.sendRedirect(request, response, "/home");

	}


	private void updateLoginUsuario(Usuario usuario) {
         usuarioService.updateLoginUsuario(usuario);
		
	}


}
