package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.InfoExtraVeiculo;
import com.SGSRveiculo.frameworkPDS.models.MarcaModelo;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;
import com.SGSRveiculo.frameworkPDS.repository.MarcaModeloRepository;
import com.SGSRveiculo.frameworkPDS.repository.VeiculoRepository;
import com.SGSRveiculo.frameworkPDS.services.IVeiculoService;
import com.SGSRveiculo.repositories.InfoExtraVeiculoRepository;

@Service
public class VeiculoService implements IVeiculoService{

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private MarcaModeloRepository modeloRepository;
	
	@Autowired
	private InfoExtraVeiculoRepository infoExtraVeiculoRepository;

	@Override
	public void inserir(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}

	@Override
	public Veiculo buscarPorId(String id) {
		return veiculoRepository.getOne(id);
	}
	@Override
	public void deletarTodos(Veiculo veiculo) {
		
		/*for(Servico serv: produto.getServicos()){
			servicoRepository.delete(serv);
		}*/
		
	}
	@Override
	public List<Veiculo> buscarTodos() {
		return veiculoRepository.findAll();
	}
	
	@Override
	public void deletar(Veiculo produto) {
		veiculoRepository.delete(produto);
	}
	
	@Override
	public void deletePorId(String idVeiculo) {
		
		veiculoRepository.deletePorId(idVeiculo);
	}
	
	@Override
	public void deleteAlertasProduto(Veiculo produto) {
		//TODO criar esse método
		
		//dataFacade.getAlertaRepository().deleteByTipoAlerta(veiculo);
	}

	@Override
	public List<String> buscarModelosPorMarca(String marca) {
		return modeloRepository.buscarModelosPorMarca(marca);
	}

	@Override
	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo) {
		return modeloRepository.buscarPorMarcaModelo(marca, modelo);
	}

	@Override
	public List<String> buscarModelos() {
		return modeloRepository.buscarModelos();
	}
	
	@Override
	public List<String> buscarMarcas() {
		// TODO Auto-generated method stub
		return modeloRepository.buscarMarcas();
	}
	
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
