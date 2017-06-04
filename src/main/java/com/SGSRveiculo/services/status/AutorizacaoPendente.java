package com.SGSRveiculo.services.status;

import java.util.ArrayList;

import com.SGSRveiculo.frameworkPDS.services.status.StatusServico;

public class AutorizacaoPendente extends StatusServico{

	public AutorizacaoPendente() {
		//informações do status
		setNomeStatus("Autorização pendente");
		//nomes das ações possíveis
		ArrayList<String> nomesAcoesParaProximoStatus = new ArrayList<String>();
		nomesAcoesParaProximoStatus.add("Autorizar serviço");
		nomesAcoesParaProximoStatus.add("Cancelar serviço");
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
