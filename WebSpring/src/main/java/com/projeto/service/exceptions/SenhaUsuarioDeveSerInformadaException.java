package com.projeto.service.exceptions;

import org.springframework.security.core.AuthenticationException;

public class SenhaUsuarioDeveSerInformadaException extends AuthenticationException{
	
	private static final long serialVersionUID = 4978797607540698157L;

	public SenhaUsuarioDeveSerInformadaException(String msg) {
		super(msg);
	}

}
