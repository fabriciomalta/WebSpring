package com.projeto.model;

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
@Table(name = "TAB_CANTEIRO")

public class Canteiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CANTEIRO_ID") 
	private Long id;

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "CANTEIRO_NOME", length = 100, nullable = false)
	private String nome;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aguadiaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((colhido == null) ? 0 : colhido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(luzdiaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Canteiro other = (Canteiro) obj;
		if (Double.doubleToLongBits(aguadiaria) != Double.doubleToLongBits(other.aguadiaria))
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
		if (plantio == null) {
			if (other.plantio != null)
				return false;
		} else if (!plantio.equals(other.plantio))
			return false;
		return true;
	}

	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "CANTEIRO_AGUA",nullable = false, precision=4, scale=3)
	private double aguadiaria;
	
	@javax.validation.constraints.NotBlank(message = "Campo obrigatório!")
	@NotNull(message = "Campo obrigatório!") 
	@Column(name = "CANTEIRO_LUZ", nullable = false, precision=4, scale=3)
	private double luzdiaria;
	
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

	public double getAguadiaria() {
		return aguadiaria;
	}

	public void setAguadiaria(double aguadiaria) {
		this.aguadiaria = aguadiaria;
	}

	public double getLuzdiaria() {
		return luzdiaria;
	}

	public void setLuzdiaria(double luzdiaria) {
		this.luzdiaria = luzdiaria;
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

	@OneToMany(mappedBy="canteiroid", targetEntity = Plantio.class, cascade=CascadeType.ALL)
	private List<Plantio> plantio;
	
	@OneToMany(mappedBy="canteiroid", targetEntity = Colhido.class, cascade=CascadeType.ALL)
	private List<Colhido> colhido;
}
