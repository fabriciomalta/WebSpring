package com.aula01web.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="TAB_ROLE_PERMISSAO")
public class RolePermissao implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -7836027277096253017L;
	
	@EmbeddedId
	private RolePermissaoId id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id", insertable=false, updatable = false)
	private Role role_id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="permissao_id", insertable=false, updatable = false)
	private Permissao permissao_id;
	
	private Escopo escopo_id;
}
