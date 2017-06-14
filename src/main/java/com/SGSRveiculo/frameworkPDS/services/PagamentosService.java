package com.SGSRveiculo.frameworkPDS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Pagamentos;
import com.SGSRveiculo.frameworkPDS.repository.PagamentosRepository;

@Service
public class PagamentosService implements IPagamentosService{

	@Autowired 
	private PagamentosRepository pagamentosRepository;



	@Override
	public boolean processarPagamentoCredito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void salvarPagamento(Pagamentos pagamento) {
		pagamentosRepository.save(pagamento);
		
	}
}
