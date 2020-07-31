package com.projeto.service.exceptions;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -537308430539319909L;

	public NegocioException(String mensagem) {
		super(mensagem);
	}
}
