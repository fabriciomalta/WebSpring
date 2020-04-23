package com.aula01web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="TAB_PERMISSAO")
public class Permissao  implements Serializable{
	
	private static final long serialVersionUID = 2793317666807558501L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="permissao_id")
	private Long id;

	@NotNull( message = "O nome da Permissão é obrigatório.")
	@NotBlank(message="O nome da Permissão é obrigatório.")
	@Column(name="permissao_nome",length=50, nullable=false)
	private String nome;
			
}