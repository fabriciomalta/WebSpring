package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.projeto.config.ConfigProjeto;
import com.sun.istack.NotNull;


@Entity
@Table(name="TAB_ESCOPO")
@SQLDelete(sql = "UPDATE tab_escopo SET registro_deletado = true WHERE escopo_id = ?")
@Where(clause=ConfigProjeto.NAO_DELETADO)
public class Escopo implements Serializable{
	
	private static final long serialVersionUID = -2610399935284425212L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="escopo_id")
	private Long id;
		
	@NotBlank
	@NotNull
	@Column(name="escopo_nome",length=15,nullable=false)
	private String nome;
	
	@Column(name="registro_deletado",nullable=false)	
	private boolean deleted = false;
	
	
	public Escopo() {
		super();
	}

	public Escopo(Long id, @NotBlank String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
		Escopo other = (Escopo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
