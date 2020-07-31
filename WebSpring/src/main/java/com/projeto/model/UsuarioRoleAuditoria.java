package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUD_USUARIO_ROLE")
public class UsuarioRoleAuditoria implements Serializable{

	private static final long serialVersionUID = -4806160377803432173L;
	
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	@Embedded
	private Auditoria auditoria;

	
	
	public UsuarioRoleAuditoria() {
		super();
	}



	public UsuarioRoleAuditoria(Long id, Role role, Auditoria auditoria) {
		super();
		this.id = id;
		this.role = role;
		this.auditoria = auditoria;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public Auditoria getAuditoria() {
		return auditoria;
	}



	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
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
		UsuarioRoleAuditoria other = (UsuarioRoleAuditoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
