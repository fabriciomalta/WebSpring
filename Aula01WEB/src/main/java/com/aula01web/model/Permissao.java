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



@Entity
@Table(name="TAB_PERMISSAO")
public class Permissao  implements Serializable{
	
	private static final long serialVersionUID = 2793317666807558501L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="permissao_id")
	private Long id;

	@NotNull( message = "O nome da Permissão é obrigatório.")
	@NotBlank(message="O nome da Permissão é obrigatório.")
	@Column(name="permissao_nome",length=50, nullable=false)
	private String nome;

	public Permissao() {
		super();
	}

	public Permissao(Long id,String nome) {
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
		Permissao other = (Permissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}