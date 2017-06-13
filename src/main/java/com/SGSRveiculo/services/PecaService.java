package com.SGSRveiculo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.repository.PecaRepository;

@Service
public class PecaService {

	
	@Autowired
	private PecaRepository pecaRepository;
	
	
	public List<Peca> listarPecas(){
		
		return pecaRepository.findAll();
		
	}


	public Peca buscarPorId(Long idPeca) {
		return pecaRepository.findOne(idPeca);
	}
	
	public void cadastrarPeca(Peca peca){
		
		pecaRepository.save(peca);
	}
}
