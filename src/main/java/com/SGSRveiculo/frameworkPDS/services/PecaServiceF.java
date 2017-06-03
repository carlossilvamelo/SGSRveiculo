package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.PecaF;
import com.SGSRveiculo.frameworkPDS.repository.PecaRepository;


@Service
public class PecaServiceF implements IPecaService{

	@Autowired
	private PecaRepository pecaRepository;
	
	@Override
	public void inserir(PecaF peca) {
		pecaRepository.save(peca);
	}

	@Override
	public void deletar(PecaF peca) {
		pecaRepository.delete(peca);
	}

	@Override
	public List<PecaF> buscarTodos() {
		return pecaRepository.findAll();
	}

	@Override
	public PecaF buscarPorId(Long id) {
		return pecaRepository.getOne(id);
	}

	

}
