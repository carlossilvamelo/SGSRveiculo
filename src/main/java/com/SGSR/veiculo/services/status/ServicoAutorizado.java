package com.SGSR.veiculo.services.status;

public class ServicoAutorizado extends StatusServico {

	public ServicoAutorizado() {
		super("Serviço autorizado");
		// TODO Auto-generated constructor stub
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return new AguerdandoPecas();
	}

}
