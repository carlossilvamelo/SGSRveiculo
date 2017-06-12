package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.Oficina;


public interface IPrestadoraService {
	public Oficina buscarPorId(String id);
	public void inserir(Oficina prestadora);
	public void deletar(Oficina prestadora);
	public List<Oficina> buscarTodos();
}
