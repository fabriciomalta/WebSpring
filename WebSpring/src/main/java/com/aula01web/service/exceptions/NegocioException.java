package com.aula01web.service.exceptions;

public class NegocioException extends RuntimeException
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6913074811463210126L;

	public NegocioException(String mensagem) {
		super(mensagem);
	}
}
