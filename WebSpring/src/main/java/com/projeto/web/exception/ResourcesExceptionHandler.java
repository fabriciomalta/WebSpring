package com.projeto.web.exception;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.projeto.security.UsuarioSistema;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ModelAttribute("usuario_logado")
	public UsuarioSistema getUsuarioLogado(@AuthenticationPrincipal UsuarioSistema usuario_logado) {
		return (usuario_logado == null ) ? null : usuario_logado; 
	}
	
}
