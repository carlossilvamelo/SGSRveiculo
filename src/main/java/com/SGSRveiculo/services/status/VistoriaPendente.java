package com.SGSRveiculo.services.status;

import java.util.ArrayList;

import com.SGSRveiculo.frameworkPDS.services.status.StatusServico;

public class VistoriaPendente extends StatusServico{

	public VistoriaPendente() {
		//informações do status
		setNomeStatus("vistoria pendente");
		//nomes das ações possíveis
		ArrayList<String> nomesAcoesParaProximoStatus = new ArrayList<String>();
		nomesAcoesParaProximoStatus.add("Finalizar vistoria");
		setNomesAcoesParaProximoStatus(nomesAcoesParaProximoStatus);


		//proximos status possiveis
		ArrayList<StatusServico> proximosStatusPossiveis = new ArrayList<StatusServico>();
		proximosStatusPossiveis.add(new AutorizacaoPendente());
		setProximosStatusPossiveis(proximosStatusPossiveis);

	}

	@Override
	public StatusServico proximo() {

		return new AutorizacaoPendente();
	}



}
