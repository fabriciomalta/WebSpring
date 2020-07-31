package com.projeto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import com.projeto.config.ConfigProjeto;


@Entity
@Table(name = "TAB_ROLE")
@SQLDelete(sql = "UPDATE tab_role SET registro_deletado = true WHERE role_id = ?")
@Where(clause=ConfigProjeto.NAO_DELETADO)
@WhereJoinTable(clause=ConfigProjeto.NAO_DELETADO)
public class Role implements Serializable {

	private static final long serialVersionUID = 3100313949814169655L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
	private Long id;
	
	@Size(max = 50, min = 3, message="O nome da regra deve ter entre {min} e {max} caracteres.")
	@NotBlank(message="Informe o nome da role.")
	@NotNull(message = "O campo nome não pode ser nulo.")
	@Column(name="role_name",length=50, nullable=false)
    private String nome;
	
	@Column(name="registro_deletado",nullable=false)	
	private boolean deleted = false;
	
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<RolePermissao> rolePermissao = new ArrayList<RolePermissao>();

    public Role() {
		super();
	}

	public Role(Long id, String nome, List<Usuario> usuarios, List<RolePermissao> rolePermissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuarios = usuarios;
		this.rolePermissao = rolePermissao;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<RolePermissao> getRolePermissao() {
		return rolePermissao;
	}

	public void setRolePermissao(List<RolePermissao> rolePermissao) {
		this.rolePermissao = rolePermissao;
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
    
}
