package com.SGSRveiculo.services.status;

import java.util.List;

import com.frameworkPDS.services.status.StatusServico;

public class VistoriaPendente extends StatusServico{
	
	public VistoriaPendente() {
		super("Vistoria pendente");
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		//OU SERVICO NÃO AUTORIZADO
		return new ServicoAutorizado();
	}

}
