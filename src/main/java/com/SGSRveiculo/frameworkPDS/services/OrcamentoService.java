package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Orcamento;
import com.SGSRveiculo.frameworkPDS.repository.OrcamentoRepository;



@Service
public class OrcamentoService implements IOrcamentoService{

	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	private ContadorServico cs;
	
	
	// acesso banco de dados
	@Override
	public void inserir(Orcamento orcamento) {
		orcamentoRepository.save(orcamento);
	}

	@Override
	public void deletar(Orcamento orcamento) {
		orcamentoRepository.delete(orcamento);
	}

	@Override
	public Orcamento buscarPorId(Long id) {
		return orcamentoRepository.getOne(id);
	}

	@Override
	public List<Orcamento> buscarTodos() {
		return orcamentoRepository.findAll();
	}

}
