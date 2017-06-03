package com.SGSRveiculo.frameworkPDS.services.busca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.SGSRveiculo.frameworkPDS.models.PecaF;

@Component
public abstract class Busca {

	private List<PecaF> pecas;

	public Busca(){
		
		pecas = new ArrayList<PecaF>();
	}
	
	
	private final List<PecaF> menorPreco(List<PecaF> listaPecas){
		
		listaPecas.stream()
		.filter((p)-> p.getPreco() != null)
		.sorted((p1, p2)->p1.getPreco().compareTo(p2.getPreco()));

		return listaPecas;
		
	}
	

	
	public final List<PecaF> buscarPecaMaisAvaliado(String idValor, String idProduto) {

		return maisAvaliado(buscaPeca());
	}
	
	
	public final List<PecaF> buscarPecaMenorPreco(String idValor, String idProduto){

		return menorPreco(buscaPeca());
	}


	private final List<PecaF> maisAvaliado(List<PecaF> listaPecas) {
		
		listaPecas.stream()
		.filter((p)-> p.getAvaliacao() != null)
		.sorted((p1, p2)->p2.getAvaliacao().compareTo(p1.getAvaliacao()));

		return listaPecas;
	}

	
	public List<PecaF> buscaPeca(){
		
		return pecas;	
	}

	

}
