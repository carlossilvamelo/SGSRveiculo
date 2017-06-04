package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.CheckIn;
import com.SGSRveiculo.frameworkPDS.models.Contratante;
import com.SGSRveiculo.frameworkPDS.models.Prestadora;
import com.SGSRveiculo.frameworkPDS.models.Produto;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.repository.CheckInRepository;
import com.SGSRveiculo.frameworkPDS.repository.ServicoRepository;


@Service
public class ServicoService implements IServicoService{

	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private CheckInRepository checkInRepository;

	
	/**
	 * Requisito gera uma atualização do status do serviço
	 * 
	 * 
	 * @param idServico
	 */
	
	@Override
	public List<Servico> buscarServicosPorContratante(Contratante contratante) {
		return servicoRepository.listarServicoPorContratante(contratante);
	}
	
	@Override
	public List<Servico> buscarServicosPorPrestadora(Prestadora prestadora) {
		return servicoRepository.listarServicoPorPrestadora(prestadora);
	}

	@Override
	public void inserir(Servico servico) {
		servicoRepository.save(servico);
	}

	@Override
	public void deletar(Servico servico) {
		servicoRepository.delete(servico);
	}
	
	

	@Override
	public Servico buscarPorId(Integer id) {
		return servicoRepository.getOne(id);
	}

	@Override
	public List<Servico> buscarTodos() {
		return servicoRepository.findAll();
	}


	@Override
	public List<Servico> buscarServicosPorIdContratante(String idCliente) {
		return null;
	}
	
	@Override
	public void atualizarProduto(Produto produto) {
		servicoRepository.updateProduto(produto);
	}

	@Override
	public List<CheckIn> listarCheckIn(Integer id) {
		// TODO Auto-generated method stub
		return checkInRepository.listarCheckInPorServico(id);
	}
	
	@Override
	public void verificarServico(Integer id){
		
		/*Servico servi = servicoRepository.findOne(id);
		
		for (CheckIn checkin : servi.getCheckIns()) {
			
			if(checkin.getClassficacao() == 0){
				servicoRepository.delete(servi);
			}
			
		}*/
	}

	@Override
	public void deletarTodos(Produto produto) {
		// TODO Auto-generated method stub
		
	}
	

}