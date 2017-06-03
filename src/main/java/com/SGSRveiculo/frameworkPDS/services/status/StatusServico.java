package com.SGSRveiculo.frameworkPDS.services.status;

import java.util.List;

public abstract class StatusServico{
	
	List<StatusServico> proximosPossiveis;
	private String nome;
	
	public StatusServico(String nome){
		this.nome = nome;
	}
	
	
	public abstract StatusServico proximo();
	
	
	public String getNome(){
		return nome;
	}
	
	

	public List<StatusServico> getProximosPossiveis() {
		return proximosPossiveis;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}


	public static StatusServico consultarStatusAtual(String nome, StatusServico statusInicial){
		
		
		while(statusInicial != null){
			if(statusInicial.getNome().equals(nome))
				return statusInicial;
			
			statusInicial = statusInicial.proximo();
			
		}
		return null;
	}
	
	
	
	
	
	
	
}
