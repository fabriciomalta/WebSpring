package com.aula01web.model;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.aula01web.util.ValidarSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TAB_USUARIO")
@ValidarSenha(confirmeSenha="confirmeSenha", senha="senha", message = "Inserir mesmas senhas ok")
@Getter @Setter
public class Usuario implements Serializable {

	/*
	 * public Usuario() {
	 * 
	 * }
	 * 
	 * @Override public String toString() { return "Usuario [id=" + id + ", nome=" +
	 * nome + ", senha=" + senha + ", confirmeSenha=" + confirmeSenha + "]"; }
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((id == null) ? 0 : id.hashCode()); return result;
	 * }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Usuario other = (Usuario) obj; if (id == null) { if (other.id != null)
	 * return false; } else if (!id.equals(other.id)) return false; return true; }
	 * 
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name ="USUARIO_ID") public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * 
	 * @javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	 * 
	 * @NotNull(message = "Campo obrigatório!")
	 * 
	 * @Column(name = "USUARIO_NOME", length = 100, nullable = false) public String
	 * getNome() { return nome; }
	 * 
	 * public void setNome(String nome) { this.nome = nome; }
	 * 
	 * @javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	 * 
	 *  public String
	 * getSenha() { return senha; }
	 * 
	 * public void setSenha(String senha) { this.senha = senha; }
	 * 
	 * //@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	 * //@NotNull(message = "Campo obrigatório!")
	 * 
	 * @Transient public String getConfirmeSenha() { return confirmeSenha; }
	 * 
	 * public void setConfirmeSenha(String confirmeSenha) { this.confirmeSenha =
	 * confirmeSenha; }
	 * 
	 * @javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	 * 
	 * @NotNull(message = "Campo obrigatório!")
	 * 
	 * @Column(name = "USUARIO_EMAIL", length = 100, nullable = false, unique =
	 * true) public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public Usuario(Long id, String nome, String senha, String confirmeSenha,
	 * String email, Boolean ativo) { super(); this.id = id; this.nome = nome;
	 * this.senha = senha; this.confirmeSenha = confirmeSenha; this.email= email;
	 * this.setAtivo(ativo); }
	 * 
	 * @Column(name="USUARIO_ATIVO", nullable=false) public boolean isAtivo() {
	 * return ativo; }
	 * 
	 * public void setAtivo(boolean ativo) { this.ativo = ativo; }
	 */
		 
		
	private static final long serialVersionUID = 603680805294180357L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="USUARIO_ID") 
	private Long id;
	
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "USUARIO_NOME", length = 100, nullable = false)
	private String nome;
	
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "USUARIO_SENHA", length = 100, nullable = false)
	private String senha;
	
	@Transient
	private String confirmeSenha;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!") 
	@NotNull(message = "Campo obrigatório!")
	@Column(name = "USUARIO_EMAIL", length = 100, nullable = false, unique =true)
	private String email;
	
	@Column(name="USUARIO_ATIVO", nullable=false)
	private boolean ativo = Boolean.TRUE;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TAB_USUARIO_ROLE",
		joinColumns = @JoinColumn(name="USUARIO_ID"),
		inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
	private List<Role> roles;
	
}
