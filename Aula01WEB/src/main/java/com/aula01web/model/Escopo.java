package com.aula01web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="TAB_ESCOPO")
public class Escopo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1901051685606823685L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="escopo_id")
	private Long id;

	@NotNull( message = "O nome do Escopo é obrigatório.")
	@NotBlank(message="O nome do Escopo é obrigatório.")
	@Column(name="escopo_nome",length=50, nullable=false)
	private String nome;
}
