package com.aula01web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.aula01web.util.ValidarSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TAB_ROLE")
@Getter @Setter
public class Role {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PERMISSAO_ID") 
	private Long id;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PERMISSAO_NOME", length = 45, nullable = false)
	private String nome;

	
}
