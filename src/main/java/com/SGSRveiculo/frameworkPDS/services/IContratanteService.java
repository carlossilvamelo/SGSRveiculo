package com.SGSRveiculo.frameworkPDS.services;

import java.util.ArrayList;
import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.Cliente;


public interface IContratanteService {
	
	public Cliente buscarID(String id);
	public Cliente buscarPorId(String id);
	public void inserir(Cliente contratante);
	public void deletar(Cliente contratante);
	public List<Cliente> buscarTodos();
	void verificaProduto(String cpf);
}
