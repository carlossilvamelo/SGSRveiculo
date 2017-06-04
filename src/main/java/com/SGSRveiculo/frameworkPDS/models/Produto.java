package com.SGSRveiculo.frameworkPDS.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Produto implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_produto")
	private String id;
	private String nome;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_marcaModelo")
	private MarcaModelo marcaModelo;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="id_contratante")
	private Contratante contratante;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public MarcaModelo getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(MarcaModelo marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public Contratante getContratante() {
		return contratante;
	}
	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	
	


	

	

	
	
}
