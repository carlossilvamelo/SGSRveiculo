package com.SGSRveiculo.services.status;

import com.SGSRveiculo.frameworkPDS.services.status.StatusServico;

public class ServicoNaoAutorizado extends StatusServico{

	public ServicoNaoAutorizado() {
		super("Serviço não autorizado");
		// TODO Auto-generated constructor stub
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return null;
	}

}