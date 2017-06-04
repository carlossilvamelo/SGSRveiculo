package com.SGSRveiculo.frameworkPDS.services;

import java.util.ArrayList;
import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.Contratante;


public interface IContratanteService {
	
	public Contratante buscarID(String id);
	public Contratante buscarPorId(String id);
	public void inserir(Contratante contratante);
	public void deletar(Contratante contratante);
	public List<Contratante> buscarTodos();
	void verificaProduto(String cpf);
}
