package com.SGSRveiculo.frameworkPDS.services;

import com.SGSRveiculo.frameworkPDS.models.Pagamentos;
import com.SGSRveiculo.frameworkPDS.models.Servico;

public interface IPagamentosService {
	public void salvarPagamento(Pagamentos pagamento);
	public boolean processarPagamentoCredito(Pagamentos pagamento, Servico servico);
	public boolean processarPagamentoBoleto(Pagamentos pagamento);
	public boolean processarPagamentoDebito(Pagamentos pagamento);
}
