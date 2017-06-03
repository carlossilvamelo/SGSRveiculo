package com.SGSRveiculo.services.status;

import com.frameworkPDS.services.status.StatusServico;

public class PreDiagnostico extends StatusServico{

	
	public PreDiagnostico() {
		super("Pré-diagnostico");
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return new VistoriaPendente();
	}
}
