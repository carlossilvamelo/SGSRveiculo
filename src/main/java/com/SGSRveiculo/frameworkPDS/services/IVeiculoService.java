package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.InfoExtraVeiculo;
import com.SGSRveiculo.frameworkPDS.models.MarcaModelo;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;

public interface IVeiculoService {
	
	//acesso ao banco
	public void inserir(Veiculo oficinaService);
	
	public void deletar(Veiculo oficinaService);
	public void deletePorId(String idVeiculo);
	
	public Veiculo buscarPorId(String id);
	public List<Veiculo> buscarTodos();

	public void deleteAlertasProduto(Veiculo produto);

	public void deletarTodos(Veiculo produto);
	
	public List<String> buscarModelosPorMarca(String marca);
	
	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo);
	
	public List<String> buscarModelos();
	
	void adicionarInfoExtra(InfoExtraVeiculo infoExtra);
		
}

