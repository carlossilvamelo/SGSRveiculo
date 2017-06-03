package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.CheckInF;
import com.SGSRveiculo.frameworkPDS.models.ContratanteF;
import com.SGSRveiculo.frameworkPDS.models.PrestadoraF;
import com.SGSRveiculo.frameworkPDS.models.ProdutoF;
import com.SGSRveiculo.frameworkPDS.models.ServicoF;


public interface IServicoService {

	public List<ServicoF> buscarServicosPorIdContratante(String contratante);
	
	//acesso ao banco
	public void inserir(ServicoF servico);
	public void deletar(ServicoF servico);
	public ServicoF buscarPorId(Integer id);
	public List<ServicoF> buscarTodos();
	public List<ServicoF> buscarServicosPorContratante(ContratanteF contratante);
	public List<ServicoF> buscarServicosPorPrestadora(PrestadoraF prestadora);
	public void atualizarProduto(ProdutoF produto);
	public void deletarTodos(ProdutoF produto);
	public List<CheckInF> listarCheckIn(Integer id);
	public void verificarServico(Integer id);
	
	
}