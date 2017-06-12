package com.SGSRveiculo.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.SGSRveiculo.frameworkPDS.models.Peca;

@Component
@SessionScope 
public class ListaPecas {

	
	private List<Peca> pecas = new ArrayList<Peca>();
	
	
	public List<Peca> getPecas(){
		
		return pecas;
	}
	
	public void add(Peca peca){
		
		pecas.add(peca);
	}
	
	public int getQuantidade(Peca peca){
		
		return pecas.size();
	}
	
	public void limpar(){
		
		pecas.forEach(p-> p = null);
	}
	
	public Double total(){
		
		Double total = 0.0;
		for(Peca peca: pecas){
			total += peca.getPreco();
		}
		
		return total;
	}
}
