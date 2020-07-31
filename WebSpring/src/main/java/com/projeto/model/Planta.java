package com.projeto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "TAB_PLANTA")
public class Planta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7080770878020676450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PLANTA_ID") 
	private Long id;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_NOME", length = 100, nullable = false)
	private String nome;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_AGUA",nullable = false, precision=4, scale=3)
	private double agua;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_LUZ", nullable = false, precision=4, scale=3)
	private double luzdiaria;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(agua);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((colhido == null) ? 0 : colhido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(luzdiaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((plantio == null) ? 0 : plantio.hashCode());
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
		Planta other = (Planta) obj;
		if (Double.doubleToLongBits(agua) != Double.doubleToLongBits(other.agua))
			return false;
		if (colhido == null) {
			if (other.colhido != null)
				return false;
		} else if (!colhido.equals(other.colhido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(luzdiaria) != Double.doubleToLongBits(other.luzdiaria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (plantio == null) {
			if (other.plantio != null)
				return false;
		} else if (!plantio.equals(other.plantio))
			return false;
		return true;
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

	public double getAgua() {
		return agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}

	public double getLuzdiaria() {
		return luzdiaria;
	}

	public void setLuzdiaria(double luzdiaria) {
		this.luzdiaria = luzdiaria;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public List<Plantio> getPlantio() {
		return plantio;
	}

	public void setPlantio(List<Plantio> plantio) {
		this.plantio = plantio;
	}

	public List<Colhido> getColhido() {
		return colhido;
	}

	public void setColhido(List<Colhido> colhido) {
		this.colhido = colhido;
	}

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "PLANTA_PESO", nullable = false, precision=4, scale=3)
	private double peso;
	
	@OneToMany(mappedBy="plantaId", targetEntity = Plantio.class, cascade=CascadeType.ALL)
	private List<Plantio> plantio;
	
	@OneToMany(mappedBy="plantaid", targetEntity = Colhido.class, cascade=CascadeType.ALL)
	private List<Colhido> colhido;
}
