package com.aula01web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aula01web.util.ValidarSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TAB_ROLE")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 3100313949814169655L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
	private Long id;
	
	@Size(max = 50, min = 3, message="O nome da regra deve ter entre {min} e {max} caracteres.")
	@NotBlank(message="Informe o nome da role.")
	@NotNull(message = "O campo nome não pode ser nulo.")
	@Column(name="role_name",length=50, nullable=false)
    private String nome;
	
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}
