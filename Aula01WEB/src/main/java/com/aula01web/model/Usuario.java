package com.aula01web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aula01web.util.ValidarSenha;


@DynamicUpdate(true) //Hibernate - update somente de campos que foram atualizados.
@Entity
@Table(name = "TAB_USUARIO")
@SQLDelete(sql = "UPDATE tab_usuario SET registro_deletado = true WHERE usuario_id = ?")
//@Where(clause=ConfigProjeto.NAO_DELETADO)
public class Usuario implements UserDetails,Serializable {

	private static final long serialVersionUID = 4230045508356480736L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USUARIO_ID")
	private Long id;
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	@NotBlank(message = "O nome deve ser informado!")
	@NotNull(message = "O campo nome não pode ser nulo!")
	@Column(name="USUARIO_NOME",length = 100, nullable = false)
	private String nome;
	
	@NotNull(message="A senha deve ser informada!")
	@NotBlank(message="A senha é obrigatória")
	@Column(name="USUARIO_SENHA",length = 100, nullable = false)
	private String senha;
	
	@Transient
	private String confirmeSenha;
	
	@NotNull(message = "O e-mail deve ser informado")
	@NotBlank(message = "o e-mail deve ser informado")
    @Email(message = "Informe um e-mail válido")
	@Column(name="USUARIO_EMAIL",length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name="ativo",nullable=false, columnDefinition="boolean default false")	
	private boolean ativo = Boolean.FALSE;
	
	@Column(name="registro_deletado",nullable=false, columnDefinition="boolean default false")	
	private boolean deleted = false;
	
	@Column(name="USUARIO_COUNT", nullable = true)
	private Integer failedLogin;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="USUARIO_LASTLOGIN", nullable = true, columnDefinition = "DATE")
	private Date lastLogin;
	
	//@WhereJoinTable(clause=ConfigProjeto.NAO_DELETADO)
	//@Where(clause=ConfigProjeto.NAO_DELETADO)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TAB_USUARIO_ROLE",
		joinColumns = @JoinColumn(name="USUARIO_ID"),
		inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
	private List<Role> roles = new ArrayList<>();

	
	public Usuario() {
	}

	
	public Usuario(Long id, String nome, String senha, String confirmeSenha, String email,
		        	boolean ativo, Integer failedLogin, Date lastLogin, List<Role> roles) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.confirmeSenha = confirmeSenha;
		this.email = email;
		this.ativo = ativo;
		this.failedLogin = failedLogin;
		this.lastLogin = lastLogin;
		this.roles = roles;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getConfirmeSenha() {
		return confirmeSenha;
	}

	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getFailedLogin() {
		return failedLogin;
	}

	public void setFailedLogin(Integer failedLogin) {
		this.failedLogin = failedLogin;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();
		for (Role role: this.getRoles()) {
			autoridades.add(new SimpleGrantedAuthority("ROLE_"+role.getNome().toUpperCase()));
		}
		return autoridades;
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return ativo;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return ativo;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return ativo;
	}

    @Transient
	@Override
	public boolean isEnabled() {
		return ativo;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getSenha();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getNome();
	}

}