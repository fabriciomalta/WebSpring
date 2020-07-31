package com.projeto.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ROLE_PERMISSAO")
public class RolePermissao implements Serializable{

	private static final long serialVersionUID = -5284909152389968812L;
	
    @EmbeddedId 
	private RolePermissaoId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", insertable = false, updatable = false)
	private Role role_id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="permissao_id", insertable = false, updatable = false)
	private Permissao permissao_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="escopo_id", insertable = false, updatable = false)
	private Escopo escopo_id;
	
	public RolePermissao() {
		super();
	}

	public RolePermissao(RolePermissaoId id, Role role_id, Permissao permissao_id, Escopo escopo_id) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.permissao_id = permissao_id;
		this.escopo_id = escopo_id;
	}

	public RolePermissaoId getId() {
		return id;
	}

	public void setId(RolePermissaoId id) {
		this.id = id;
	}

	public Role getRole_id() {
		return role_id;
	}

	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}

	public Permissao getPermissao_id() {
		return permissao_id;
	}

	public void setPermissao_id(Permissao permissao_id) {
		this.permissao_id = permissao_id;
	}

	public Escopo getEscopo_id() {
		return escopo_id;
	}

	public void setEscopo_id(Escopo escopo_id) {
		this.escopo_id = escopo_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePermissao other = (RolePermissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}  

	
	
}
