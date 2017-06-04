package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.MarcaModelo;
import com.SGSRveiculo.frameworkPDS.models.Produto;


public interface IProdutoService {
	
	//acesso ao banco
	public void inserir(Produto produto);
	
	public void deletar(Produto produto);
	public void deletePorId(String idProduto);
	
	public Produto buscarPorId(String id);
	public List<Produto> buscarTodos();

	public void deleteAlertasProduto(Produto produto);

	public void deletarTodos(Produto produto);
	
	public List<String> buscarModelosPorMarca(String marca);
	
	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo);
	
	public List<String> buscarModelos();
	

	
	
	
}
