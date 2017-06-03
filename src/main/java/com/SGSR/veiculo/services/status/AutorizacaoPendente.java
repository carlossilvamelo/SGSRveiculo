package com.SGSR.veiculo.services.status;

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
