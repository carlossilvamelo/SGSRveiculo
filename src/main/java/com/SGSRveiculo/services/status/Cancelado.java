package com.SGSRveiculo.services.status;

import java.util.ArrayList;

import com.SGSRveiculo.frameworkPDS.services.status.StatusServico;

public class Cancelado extends StatusServico{

	public Cancelado() {
		//informações do status
		setNomeStatus("Pré-diagnostico");
		//nomes das ações possíveis
		ArrayList<String> nomesAcoesParaProximoStatus = new ArrayList<String>();
		nomesAcoesParaProximoStatus.add("Iniciar vistoria");
		setNomesAcoesParaProximoStatus(nomesAcoesParaProximoStatus);


		//proximos status possiveis
		ArrayList<StatusServico> proximosStatusPossiveis = new ArrayList<StatusServico>();
		proximosStatusPossiveis.add(new VistoriaPendente());
		setProximosStatusPossiveis(proximosStatusPossiveis);
	}

	@Override
	public StatusServico proximo() {
		// TODO Auto-generated method stub
		return null;
	}

}
