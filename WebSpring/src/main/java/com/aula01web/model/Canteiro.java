package com.aula01web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TAB_CANTEIRO")
@Getter @Setter
public class Canteiro {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CANTEIRO_ID") 
	private Long id;

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "CANTEIRO_NOME", length = 100, nullable = false)
	private String nome;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "CANTEIRO_AGUA",nullable = false, precision=4, scale=3)
	private double aguadiaria;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "CANTEIRO_LUZ", nullable = false, precision=4, scale=3)
	private double luzdiaria;
}
