package com.aula01web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class RolePermissaoId implements Serializable{

	/**
	 * 
	 */
	@EqualsAndHashCode.Include
	private static final long serialVersionUID = 4828629963859741929L;
	@Column(name="role_id", insertable=false, updatable = false, nullable = false)
	private Long roleId;
	
	@EqualsAndHashCode.Include
	@Column(name="permissao_id", insertable = false, updatable = false, nullable = false)
	private Long permissaoId;
	
	
	@EqualsAndHashCode.Include
	@Column(name="escopo_id", insertable = false, updatable = false, nullable = false)
	private Long escopoId;
}
