package com.projeto.config;

import org.springframework.security.core.context.SecurityContextHolder;

import com.projeto.model.Usuario;
import com.projeto.security.UsuarioSistema;

public class ConfigProjeto {

	public static final String NAO_DELETADO = "registro_deletado = false"; 
	
	public static final Integer  LISTA_VAZIA = -1; 
	
	public static final int INITIAL_PAGE = 0;
    
    public static final int INITIAL_PAGE_SIZE = 5;
	
	public static final  int[] PAGE_SIZES = {5, 10, 15, 20};
	
	public static final String INCLUSAO = "INSERT";
	
	public static final String ALTERACAO = "UPDATE";
	
	public static final String EXCLUSAO = "DELETE";
	
	
	public static Usuario pegarUsuario() {
		UsuarioSistema us = (UsuarioSistema) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return us.getUsuario();
	}
}
