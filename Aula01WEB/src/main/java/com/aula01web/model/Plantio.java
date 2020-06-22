package com.aula01web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TAB_PLANTIO")
public class Plantio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PLANTIO_ID") 
	private Long id;
	
	//CHAVE ESTRANGEIRA DA TABELA PLANTA
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTIO_PLANTAID",nullable = false)
	private Long plantaId;
	
	
	//CHAVE ESTRANGEIRA DA TABELA FUNCIONARIO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTIO_FUNCID",nullable = false)
	private Long funcionarioId;
	
	
	//CHAVE ESTRANGEIRA DA TABELA CANTEIRO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTIO_CANTID", nullable = false)
	private double canteiroId;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTIO_data", nullable = false, length = 10)
	private String data;

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTIO_sementes", nullable = false)
	private int sementes;
}
