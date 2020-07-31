package com.projeto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TAB_COLHIDO")
public class Colhido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6195564709239380722L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="COLHIDO_ID") 
	private Long id;
	
	//CHAVE ESTRANGEIRA DA TABELA PLANTA
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COLHIDO_PLANTAID") 
	private Planta plantaid;
	
	
	//CHAVE ESTRANGEIRA DA TABELA FUNCIONARIO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COLHIDO_FUNCID") 
	private Usuario funcionario;
	
	//CHAVE ESTRANGEIRA DA TABELA CANTEIRO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COLHIDO_CANTID") 
	private Canteiro canteiroid;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canteiroid == null) ? 0 : canteiroid.hashCode());
		result = prime * result + ((datacolhido == null) ? 0 : datacolhido.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plantaid == null) ? 0 : plantaid.hashCode());
		result = prime * result + sementes;
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
		Colhido other = (Colhido) obj;
		if (canteiroid == null) {
			if (other.canteiroid != null)
				return false;
		} else if (!canteiroid.equals(other.canteiroid))
			return false;
		if (datacolhido == null) {
			if (other.datacolhido != null)
				return false;
		} else if (!datacolhido.equals(other.datacolhido))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (plantaid == null) {
			if (other.plantaid != null)
				return false;
		} else if (!plantaid.equals(other.plantaid))
			return false;
		if (sementes != other.sementes)
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Planta getPlantaid() {
		return plantaid;
	}

	public void setPlantaid(Planta plantaid) {
		this.plantaid = plantaid;
	}

	public Usuario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
	}

	public Canteiro getCanteiroid() {
		return canteiroid;
	}

	public void setCanteiroid(Canteiro canteiroid) {
		this.canteiroid = canteiroid;
	}

	public Date getDatacolhido() {
		return datacolhido;
	}

	public void setDatacolhido(Date datacolhido) {
		this.datacolhido = datacolhido;
	}

	public int getSementes() {
		return sementes;
	}

	public void setSementes(int sementes) {
		this.sementes = sementes;
	}

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@DateTimeFormat(pattern="dd/MM/yyyy'T'hh:mm")
	//@Temporal(TemporalType.DATE)
	@Column(name = "COLHIDO_DATA", nullable = false, columnDefinition = "DATETIME")
	private Date datacolhido;

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "COLHIDO_QUANTIDADE", nullable = false)
	private int sementes;
	
	
}
