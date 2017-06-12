package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.repository.OficinaRepository;


@Service
public class PrestadoraService implements IPrestadoraService{
	
	@Autowired
	private OficinaRepository oficinaRepository;
	//@Autowired
	//private LogicaAcompanhamento logicaAcompanhamento;
	
	@Override
	public void inserir(Oficina oficina) {
		oficinaRepository.save(oficina);
	}

	@Override
	public void deletar(Oficina oficina) {
		oficinaRepository.delete(oficina);
	}

	@Override
	public Oficina buscarPorId(String id) {
		return oficinaRepository.findOne(id);
	}

	@Override
	public List<Oficina> buscarTodos() {
		return oficinaRepository.findAll();
	}

}
