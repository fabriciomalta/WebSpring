package com.projeto.service;

import java.io.InputStream;
import java.util.UUID;

import com.projeto.service.storage.Foto;

public interface FotoStorageService {

	InputStream recuperar(String nomeArquivo);
	
	void armazenar(Foto foto);
	
	boolean remover(String nomeArquivo);
	
	byte[] recuperarFoto(String nomeArquivo);
	
	default void substituir(String nomeArquivoAntigo, Foto foto) {
		this.armazenar(foto);
		
		if (nomeArquivoAntigo != null) {
			this.remover(nomeArquivoAntigo);
		}
	}
	
	default String gerarNomeArquivo(String nomeOriginal) {
		return UUID.randomUUID().toString() + "_" + nomeOriginal;
	}
		
}
