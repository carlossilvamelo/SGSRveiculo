package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Orcamento;
import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.repository.OficinaRepository;
import com.SGSRveiculo.frameworkPDS.repository.OrcamentoRepository;
import com.SGSRveiculo.frameworkPDS.repository.PecaRepository;
import com.SGSRveiculo.services.busca.BuscaPecaSite;

@Service
public class OficinaService implements IOficinaService{

	@Autowired
	private PecaRepository pecaRepository;
	@Autowired
	private OficinaRepository oficinaRepository;
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	private BuscaPecaSite buscaSite;
	
	@Override
	public List<Oficina> buscarTodasOficinas(){
		
		return oficinaRepository.findAll();
	}
	
	@Override
	public Orcamento gerarOrcamento(List<Peca> pecas){
		
		List<Peca> novasPecas;
		Orcamento novoOrcamento = new Orcamento();
		
		for (Peca peca : pecas) {
			
			if(pecaRepository.verificarDisponibilidade(peca.getNome()) == null){
				
				novoOrcamento.addPeca(peca);
				
			}
			
		}
		
		return novoOrcamento;
	}
	
	@Override
	public boolean verificarDisponibilidade(Peca peca){
		
		pecaRepository.verificarDisponibilidade(peca.getNome());
		
		return false;
		
	}

	@Override
	public List<Peca> buscarPecaSite(String url, String nomePeca) {
		
		
		buscaSite = new BuscaPecaSite(url, nomePeca);
		return buscaSite.buscarPecaMenorPreco();
	}

	@Override
	public void cadastrarPecasSite(String url, String nomePeca) {
		
		try{
			List<Peca> pecas = buscarPecaSite(url, nomePeca);
			
			for (Peca peca : pecas) {
				
				if(pecaRepository.verificarDisponibilidade(peca.getNome()) == null){
					
					pecaRepository.save(peca);
				}
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

	public void inserir(Oficina oficina) {
		oficinaRepository.save(oficina);
		
	}

	public Oficina buscarPorId(String id) {
		return oficinaRepository.findOne(id);
	}


}
