package com.aula01web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TAB_COLHIDO")
public class Colhido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="COLHIDO_ID") 
	private Long id;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "COLHIDO_PLANTAID",nullable = false)
	private Long plantaId;
	
	
	//CHAVE ESTRANGEIRA DA TABELA FUNCIONARIO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "COLHIDO_FUNCID",nullable = false)
	private Long funcionarioId;
	
	
	//CHAVE ESTRANGEIRA DA TABELA CANTEIRO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "COLHIDO_CANTID", nullable = false)
	private double canteiroId;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "COLHIDO_data", nullable = false, length = 10)
	private String data;

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "COLHIDO_QUANTIDADE", nullable = false)
	private int sementes;
	
	
}
