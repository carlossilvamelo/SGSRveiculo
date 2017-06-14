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

import com.SGSRveiculo.enumeracoes.EnumCores;


@Entity
public class Veiculo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_veiculo")
	private String id;
	private String nome;
	
	@OneToOne
	@JoinColumn(name="id_marcaModelo")
	private MarcaModelo marcaModelo;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	private String placa;
	private Integer ano;
	private Integer cambio;
	private EnumCores cor;
	private InfoExtraVeiculo infoExtraVeiculo;
	
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getCambio() {
		return cambio;
	}

	public void setCambio(Integer cambio) {
		this.cambio = cambio;
	}
	
	public EnumCores getCor() {
		return cor;
	}
	public void setCor(EnumCores cor) {
		this.cor = cor;
}

	public InfoExtraVeiculo getInfoExtraVeiculo() {
		return infoExtraVeiculo;
	}

	public void setInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo) {
		this.infoExtraVeiculo = infoExtraVeiculo;
}


	
}