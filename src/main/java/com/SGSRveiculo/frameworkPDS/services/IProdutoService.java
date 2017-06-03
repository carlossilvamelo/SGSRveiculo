package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.MarcaModeloF;
import com.SGSRveiculo.frameworkPDS.models.ProdutoF;


public interface IProdutoService {
	
	//acesso ao banco
	public void inserir(ProdutoF produto);
	
	public void deletar(ProdutoF produto);
	public void deletePorId(String idProduto);
	
	public ProdutoF buscarPorId(String id);
	public List<ProdutoF> buscarTodos();

	public void deleteAlertasProduto(ProdutoF produto);

	public void deletarTodos(ProdutoF produto);
	
	public List<String> buscarModelosPorMarca(String marca);
	
	public MarcaModeloF buscarPorMarcaModelo(String marca, String modelo);
	
	public List<String> buscarModelos();
	

	
	
	
}
