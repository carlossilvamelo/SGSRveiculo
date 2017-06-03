package com.SGSRveiculo.frameworkPDS.services;

import java.util.ArrayList;
import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.ContratanteF;


public interface IContratanteService {
	
	public ContratanteF buscarID(String id);
	public ContratanteF buscarPorId(String id);
	public void inserir(ContratanteF contratante);
	public void deletar(ContratanteF contratante);
	public List<ContratanteF> buscarTodos();
	void verificaProduto(String cpf);
}
