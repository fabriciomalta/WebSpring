package com.projeto.model.enumerate;

public enum TipoOperacao {

	
	INCLUSAO("INSERT"),
	ALTERACAO("UPDATE"),
	EXCLUSAO("DELETE");
	
	private String descricao;

	TipoOperacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
