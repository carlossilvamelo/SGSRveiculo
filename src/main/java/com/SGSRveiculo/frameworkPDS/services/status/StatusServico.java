package com.SGSRveiculo.frameworkPDS.services.status;

import java.util.ArrayList;
import java.util.List;

public abstract class StatusServico{
	
	private ArrayList<StatusServico> proximosStatusPossiveis;
	
	private String nomeStatus;
	private ArrayList<String> nomesAcoesParaProximoStatus;
	
	public StatusServico(){
		
	}
	
	
	public abstract StatusServico proximo();

	public static StatusServico consultarStatusAtual(String nome, StatusServico statusInicial){
		
		
		while(statusInicial != null){
			if(statusInicial.getNomeStatus().equals(nome))
				return statusInicial;
			
			statusInicial = statusInicial.proximo();
			
		}
		return null;
	}


	public ArrayList<StatusServico> getProximosStatusPossiveis() {
		return proximosStatusPossiveis;
	}


	public void setProximosStatusPossiveis(ArrayList<StatusServico> proximosStatusPossiveis) {
		this.proximosStatusPossiveis = proximosStatusPossiveis;
	}


	public String getNomeStatus() {
		return nomeStatus;
	}


	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}


	public ArrayList<String> getNomesAcoesParaProximoStatus() {
		return nomesAcoesParaProximoStatus;
	}


	public void setNomesAcoesParaProximoStatus(ArrayList<String> nomesAcoesParaProximoStatus) {
		this.nomesAcoesParaProximoStatus = nomesAcoesParaProximoStatus;
	}


	
	
	
	
	
	
	
}
