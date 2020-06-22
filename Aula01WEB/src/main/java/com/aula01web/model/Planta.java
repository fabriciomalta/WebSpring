package com.aula01web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.aula01web.util.ValidarSenha;



@Entity
@Table(name = "TAB_PLANTA")
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PLANTA_ID") 
	private Long id;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_NOME", length = 100, nullable = false)
	private String nome;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_AGUA",nullable = false, precision=4, scale=3)
	private double agua;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_LUZ", nullable = false, precision=4, scale=3)
	private double luzdiaria;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_PESO", nullable = false, precision=4, scale=3)
	private double peso;
	
}
