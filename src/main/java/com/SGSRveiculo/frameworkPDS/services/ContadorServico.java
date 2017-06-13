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
		valor -= orcamento.getDescontoValor();
		valor += orcamento.getValorAdicional();
		valor = taxasSobreValor(valor);
		valor = addDescontoPorcentagem(valor, orcamento);
		return valor;
	}

	
	
	/**
	 * Para não adiconar taxas ou descontos basta apenas retornar o valor
	 * @param valor
	 * @param orcamento
	 * @return
	 */
	public abstract Double addDescontoPorcentagem(Double valor, Orcamento orcamento);

	/**
	 * Para não adiconar taxas ou descontos basta apenas retornar o valor
	 * @param valor
	 * @return
	 */
	public abstract Double taxasSobreValor(Double valor);
	
	public abstract Double contabilizarValorProprio(Orcamento orcamento);

	
	
	

}
