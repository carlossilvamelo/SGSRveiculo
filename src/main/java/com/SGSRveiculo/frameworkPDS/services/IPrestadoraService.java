package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.PrestadoraF;


public interface IPrestadoraService {
	public PrestadoraF buscarPorId(String id);
	public void inserir(PrestadoraF prestadora);
	public void deletar(PrestadoraF prestadora);
	public List<PrestadoraF> buscarTodos();
}
