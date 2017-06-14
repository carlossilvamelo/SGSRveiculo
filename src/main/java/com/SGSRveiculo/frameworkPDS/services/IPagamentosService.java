package com.SGSRveiculo.frameworkPDS.services;

import com.SGSRveiculo.frameworkPDS.models.Pagamentos;

public interface IPagamentosService {
	public void salvarPagamento(Pagamentos pagamento);
	public boolean processarPagamentoCredito();
}
