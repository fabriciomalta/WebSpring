package com.projeto.util.dto;

public class ExcluirFoto {

	private String nomeArquivo;
	private String contentType;
	private String id;
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	@Override
	public String toString() {
		return "ExcluirFoto [nomeArquivo=" + nomeArquivo + ", id=" + id + "]";
	}
	
	
	
}
