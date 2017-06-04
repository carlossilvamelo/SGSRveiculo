package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.CheckIn;
import com.SGSRveiculo.frameworkPDS.models.Contratante;
import com.SGSRveiculo.frameworkPDS.models.Prestadora;
import com.SGSRveiculo.frameworkPDS.models.Produto;
import com.SGSRveiculo.frameworkPDS.models.Servico;


public interface IServicoService {

	public List<Servico> buscarServicosPorIdContratante(String contratante);
	
	//acesso ao banco
	public void inserir(Servico servico);
	public void deletar(Servico servico);
	public Servico buscarPorId(Integer id);
	public List<Servico> buscarTodos();
	public List<Servico> buscarServicosPorContratante(Contratante contratante);
	public List<Servico> buscarServicosPorPrestadora(Prestadora prestadora);
	public void atualizarProduto(Produto produto);
	public void deletarTodos(Produto produto);
	public List<CheckIn> listarCheckIn(Integer id);
	public void verificarServico(Integer id);
	
	
}