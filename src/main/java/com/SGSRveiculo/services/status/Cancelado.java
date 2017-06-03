package com.SGSRveiculo.services.status;

import com.frameworkPDS.services.status.StatusServico;

public class Cancelado extends StatusServico{
	
	public Cancelado() {
		super("Cancelado");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return null;
	}

}
