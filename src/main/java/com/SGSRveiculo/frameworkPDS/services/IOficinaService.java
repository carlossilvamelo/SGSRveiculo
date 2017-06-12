package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Orcamento;
import com.SGSRveiculo.frameworkPDS.models.Peca;

public interface IOficinaService {

	public boolean verificarDisponibilidade(Peca peca);
	public List<Peca> buscarPecaSite(String url, String nomePeca);
	public Orcamento gerarOrcamento(List<Peca> pecas);
	public void cadastrarPecasSite(String url, String nomePeca);
	public List<Oficina> buscarTodasOficinas();
}
