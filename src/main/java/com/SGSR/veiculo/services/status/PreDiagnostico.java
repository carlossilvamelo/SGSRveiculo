package com.SGSR.veiculo.services.status;

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
