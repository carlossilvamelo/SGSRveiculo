package com.SGSRveiculo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.repository.MarcaModeloRepository;
import com.SGSRveiculo.frameworkPDS.repository.ProdutoRepository;
import com.SGSRveiculo.frameworkPDS.services.ProdutoService;
import com.SGSRveiculo.models.InfoExtraVeiculo;
import com.SGSRveiculo.models.Veiculo;
import com.SGSRveiculo.repositories.InfoExtraVeiculoRepository;

@Service
public class VeiculoService extends ProdutoService implements IVeiculoService {
	
	@Autowired
	private ProdutoRepository veiculoRepository;
	@Autowired
	private InfoExtraVeiculoRepository infoExtraVeiculoRepository;
	@Autowired
	private MarcaModeloRepository marcaModeloRepository;
	
	@Override
	public void adicionarInfoExtra(InfoExtraVeiculo infoExtra) {
		
		
		boolean exist = veiculoRepository.exists(infoExtra.getId());
	
		if(exist){

			infoExtra.setKmAnterior(infoExtraVeiculoRepository.getKmTotalVeiculo(infoExtra.getId()));
			
		}
		
		Veiculo veiculo = (Veiculo)veiculoRepository.findOne(infoExtra.getId());
		
		veiculo.setInfoExtraVeiculo(infoExtra);
		
		
		veiculoRepository.save(veiculo);
		
		
		
	}
}
