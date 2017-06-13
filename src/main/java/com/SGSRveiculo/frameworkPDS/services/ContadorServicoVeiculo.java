package com.SGSRveiculo.frameworkPDS.services;

import com.SGSRveiculo.frameworkPDS.models.Orcamento;

public class ContadorServicoVeiculo extends ContadorServico{

	@Override
	public Double addDescontoPorcentagem(Double valor, Orcamento orcamento) {
		Double valorDesconto = (double) (100 - orcamento.getDescontoPorcentagem());
		valor = valor * (valorDesconto/100);
		return valor;
	}

	@Override
	public Double taxasSobreValor(Double valor) {
		//taxa de serviços de TI
		return valor * 1.1;
	}

	@Override
	public Double contabilizarValorProprio(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return null;
	}
}
