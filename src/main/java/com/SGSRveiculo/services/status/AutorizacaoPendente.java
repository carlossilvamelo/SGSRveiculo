package com.SGSRveiculo.services.status;

import com.SGSRveiculo.frameworkPDS.services.status.StatusServico;

public class AutorizacaoPendente extends StatusServico{

	public AutorizacaoPendente() {
		super("Autorizacao pendente");
		// TODO Auto-generated constructor stub
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return new ServicoAutorizado();
	}

}
