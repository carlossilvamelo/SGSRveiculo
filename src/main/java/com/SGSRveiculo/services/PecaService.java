package com.SGSRveiculo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.repository.PecaRepository;
import com.SGSRveiculo.frameworkPDS.services.IPecaService;

@Service
public class PecaService implements IPecaService{

	
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


	@Override
	public void inserir(Peca peca) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deletar(Peca peca) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Peca> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Peca buscarPorNome(String nome) {
		return pecaRepository.buscarPorNome(nome);
	}
}
