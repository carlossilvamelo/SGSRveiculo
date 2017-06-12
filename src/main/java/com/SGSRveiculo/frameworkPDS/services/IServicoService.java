package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.CheckIn;
import com.SGSRveiculo.frameworkPDS.models.Cliente;
import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;


public interface IServicoService {

	public List<Servico> buscarServicosPorIdContratante(String cliente);
	
	//acesso ao banco
	public void inserir(Servico servico);
	public void deletar(Servico servico);
	public Servico buscarPorId(Integer id);
	public List<Servico> buscarTodos();
	public List<Servico> buscarServicosPorCliente(Cliente cliente);
	public List<Servico> buscarServicosPorOficina(Oficina oficina);
	public void atualizarVeiculo(Veiculo veiculo);
	public void deletarTodos(Veiculo veiculo);
	public List<CheckIn> listarCheckIn(Integer id);
	public void verificarServico(Integer id);
	
	
}