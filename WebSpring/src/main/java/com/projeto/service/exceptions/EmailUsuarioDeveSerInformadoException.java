package com.projeto.service.exceptions;

import org.springframework.security.core.AuthenticationException;

public class EmailUsuarioDeveSerInformadoException extends AuthenticationException {


	private static final long serialVersionUID = -1516507615791790629L;

	public EmailUsuarioDeveSerInformadoException(String msg) {
		super(msg);
	}

}
