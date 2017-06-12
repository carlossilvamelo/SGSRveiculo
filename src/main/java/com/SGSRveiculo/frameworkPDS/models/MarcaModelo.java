package com.SGSRveiculo.frameworkPDS.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
public class MarcaModelo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marcaModelo")
	private Long id;
	private String marca;
	private String modelo;
	@OneToOne(mappedBy="marcaModelo", cascade=CascadeType.ALL)
	private Veiculo veiculo;

	public MarcaModelo(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idMarca) {
		this.id = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Veiculo getProduto() {
		return veiculo;
	}

	public void setProduto(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}