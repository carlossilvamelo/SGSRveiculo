package com.SGSRveiculo.models;

import javax.persistence.Entity;

import com.frameworkPDS.models.ProdutoF;

@Entity
public class Veiculo extends ProdutoF{
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
