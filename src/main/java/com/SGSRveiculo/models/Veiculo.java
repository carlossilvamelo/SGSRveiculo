package com.SGSRveiculo.models;

import javax.persistence.Entity;

import com.SGSRveiculo.frameworkPDS.models.Produto;



@Entity
public class Veiculo extends Produto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String placa;
	private Integer ano;
	//private EnumCores cor;
	private Integer cambio;
	
	private InfoExtraVeiculo infoExtraVeiculo;

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

	public InfoExtraVeiculo getInfoExtraVeiculo() {
		return infoExtraVeiculo;
	}

	public void setInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo) {
		this.infoExtraVeiculo = infoExtraVeiculo;
	}
	
}
