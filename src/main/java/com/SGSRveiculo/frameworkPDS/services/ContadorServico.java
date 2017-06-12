package com.SGSRveiculo.frameworkPDS.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Orcamento;
import com.SGSRveiculo.frameworkPDS.models.Peca;

@Service
public abstract class ContadorServico {
	
	
	
	
	public final Double contabilizarServiço(Orcamento orcamento) {
		Double valor= 0.0;
		valor += orcamento.getPrecoMaoObra();
		//puxar a lista de pecas com o id do orcamento
		ArrayList<Peca> pecas = (ArrayList<Peca>) orcamento.getPecas();
		for (Peca peca : pecas) {
			valor += peca.getPreco();
		}
		valor -= addDescontoValor(orcamento);
		valor += valorAdicional(orcamento);
		valor = addDescontoPorcentagem(valor, orcamento);
		return valor;
	}

	
	public Double addDescontoValor(Orcamento orcamento) {
		
		return orcamento.getDescontoValor();
	}
	
	public Double addDescontoPorcentagem(Double valor, Orcamento orcamento) {
		return valor * (1-(orcamento.getDescontoPorcentagem()/100));
	}

	public Double valorAdicional(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValorAdicional();
	}
	
	public abstract Double contabilizarValorProprio(Orcamento orcamento);

	
	
	

}
