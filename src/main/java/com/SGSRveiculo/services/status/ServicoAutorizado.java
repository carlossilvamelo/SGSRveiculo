package com.SGSRveiculo.services.status;

import com.frameworkPDS.services.status.StatusServico;

public class ServicoAutorizado extends StatusServico {

	public ServicoAutorizado() {
		super("Serviço autorizado");
		// TODO Auto-generated constructor stub
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return new AguardandoPecas();
	}

}
