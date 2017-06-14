package com.SGSRveiculo.frameworkPDS.services;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Pagamentos;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.repository.PagamentosRepository;

@Service
public class PagamentosService implements IPagamentosService{

	@Autowired 
	private PagamentosRepository pagamentosRepository;

	

	@Override
	public void salvarPagamento(Pagamentos pagamento) {
		pagamentosRepository.save(pagamento);
		
	}


	@Override
	public boolean processarPagamentoBoleto(Pagamentos pagamento) {
		salvarPagamento(pagamento);
		return false;
	}


	@Override
	public boolean processarPagamentoCredito(Pagamentos pagamento,Servico servico) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pagamento.setFormaPagamento("credito");
		pagamento.setDataPagamento(new GregorianCalendar());
		pagamento.setResumoServico(servico.getDescricao());
		pagamento.setModeloVeiculo(servico.getVeiculo().getMarcaModelo().getModelo());
		salvarPagamento(pagamento);
		return true;
	}


	@Override
	public boolean processarPagamentoDebito(Pagamentos pagamento) {
		// TODO Auto-generated method stub
		return false;
	}
}
