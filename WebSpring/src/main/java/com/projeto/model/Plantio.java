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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TAB_PLANTIO")
public class Plantio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4030614940102067626L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PLANTIO_ID") 
	private Long id;
	
	//CHAVE ESTRANGEIRA DA TABELA PLANTA
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="PLANTA_ID")
	private Planta plantaId;
	
	
	//CHAVE ESTRANGEIRA DA TABELA FUNCIONARIO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USUARIO_ID") 
	private Usuario funcionario;
	
	
	//CHAVE ESTRANGEIRA DA TABELA CANTEIRO
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CANTEIRO_ID") 
	private Canteiro canteiroid;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@DateTimeFormat(pattern="dd/MM/yyyy'T'hh:mm")
	//@Temporal(TemporalType.DATE)
	@Column(name = "PLANTIO_data", nullable = false, columnDefinition = "DATETIME")
	private Date dataplantio;

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTIO_sementes", nullable = false)
	private int sementes;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canteiroid == null) ? 0 : canteiroid.hashCode());
		result = prime * result + ((dataplantio == null) ? 0 : dataplantio.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plantaId == null) ? 0 : plantaId.hashCode());
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
		Plantio other = (Plantio) obj;
		if (canteiroid == null) {
			if (other.canteiroid != null)
				return false;
		} else if (!canteiroid.equals(other.canteiroid))
			return false;
		if (dataplantio == null) {
			if (other.dataplantio != null)
				return false;
		} else if (!dataplantio.equals(other.dataplantio))
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
		if (plantaId == null) {
			if (other.plantaId != null)
				return false;
		} else if (!plantaId.equals(other.plantaId))
			return false;
		if (sementes != other.sementes)
			return false;
		return true;
	}

	public Planta getPlantaId() {
		return plantaId;
	}

	public void setPlantaId(Planta plantaId) {
		this.plantaId = plantaId;
	}

	public Canteiro getCanteiroid() {
		return canteiroid;
	}

	public void setCanteiroid(Canteiro canteiroid) {
		this.canteiroid = canteiroid;
	}

	public Date getDataplantio() {
		return dataplantio;
	}

	public void setDataplantio(Date dataplantio) {
		this.dataplantio = dataplantio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSementes() {
		return sementes;
	}

	public void setSementes(int sementes) {
		this.sementes = sementes;
	}
}
