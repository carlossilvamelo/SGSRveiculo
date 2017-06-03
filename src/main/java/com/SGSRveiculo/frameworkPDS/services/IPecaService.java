package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.PecaF;



public interface IPecaService {

	//acesso ao banco
	public void inserir(PecaF peca);
	public void deletar(PecaF peca);
	public List<PecaF> buscarTodos();
	public PecaF buscarPorId(Long id);
}
