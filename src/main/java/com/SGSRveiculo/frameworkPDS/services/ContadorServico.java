package com.SGSRveiculo.frameworkPDS.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.OrcamentoF;
import com.SGSRveiculo.frameworkPDS.models.PecaF;

@Service
public abstract class ContadorServico {
	

	
	
	public final Double contabilizarServiço(OrcamentoF orcamento) {
		Double valor= 0.0;
		valor += orcamento.getPrecoMaoObra();
		
		ArrayList<PecaF> pecas = (ArrayList<PecaF>) orcamento.getPecasTroca();
		for (PecaF peca : pecas) {
			valor += peca.getPreco();
		}
		valor -= addDescontoValor(orcamento);
		valor += valorAdicional(orcamento);
		valor = addDescontoPorcentagem(valor, orcamento);
		return valor;
	}

	
	public Double addDescontoValor(OrcamentoF orcamento) {
		
		return orcamento.getDescontoValor();
	}
	
	public Double addDescontoPorcentagem(Double valor, OrcamentoF orcamento) {
		return valor * (1-(orcamento.getDescontoPorcentagem()/100));
	}

	public Double valorAdicional(OrcamentoF orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValorAdicional();
	}
	
	public abstract Double contabilizarValorProprio(OrcamentoF orcamento);

	
	
	

}
