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
public class ProdutoF implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_produto")
	private String id;
	private String nome;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_marcaModelo")
	private MarcaModeloF marcaModelo;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="id_contratante")
	private ContratanteF contratante;
	
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
	public MarcaModeloF getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(MarcaModeloF marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public ContratanteF getContratante() {
		return contratante;
	}
	public void setContratante(ContratanteF contratante) {
		this.contratante = contratante;
	}

	
	


	

	

	
	
}
