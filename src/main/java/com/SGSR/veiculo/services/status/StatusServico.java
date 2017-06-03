package com.SGSR.veiculo.services.status;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Service;


@Service
public abstract class StatusServico{
	
	
	private String nome;
	
	public StatusServico(String nome){
		this.nome = nome;
	}
	
	
	public abstract StatusServico proximo();
	
	
	public String getNome(){
		return nome;
	}
	
	
/*
	public static StatusServico consultarStatusAtual(String nome){
		StatusServico statusAtual=new Iniciado();
		
		
		while(statusAtual != null){
			if(statusAtual.getNome().equals(nome))
				return statusAtual;
			
			statusAtual = statusAtual.proximo();
			
		}
		return null;
	}
	*/
	
	
	
	
	
	
}
