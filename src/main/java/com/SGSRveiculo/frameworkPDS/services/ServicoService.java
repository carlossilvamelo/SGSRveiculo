package com.SGSRveiculo.frameworkPDS.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.enumeracoes.EnumStatus;
import com.SGSRveiculo.frameworkPDS.models.CheckIn;
import com.SGSRveiculo.frameworkPDS.models.Cliente;
import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Orcamento;
import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;
import com.SGSRveiculo.frameworkPDS.repository.CheckInRepository;
import com.SGSRveiculo.frameworkPDS.repository.OficinaRepository;
import com.SGSRveiculo.frameworkPDS.repository.OrcamentoRepository;
import com.SGSRveiculo.frameworkPDS.repository.PecaRepository;
import com.SGSRveiculo.frameworkPDS.repository.ServicoRepository;
import com.SGSRveiculo.services.busca.BuscaPecaSite;


@Service
public class ServicoService implements IServicoService{

	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private CheckInRepository checkInRepository;
	@Autowired
	private PecaRepository pecaRepository;
	@Autowired
	private OficinaRepository oficinaRepository;
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	private BuscaPecaSite buscaSite;
	
	/**
	 * Requisito gera uma atualização do status do serviço
	 * 
	 * 
	 * @param idServico
	 */
	
	@Override
	public List<Servico> buscarServicosPorCliente(Cliente cliente) {
		return servicoRepository.listarServicoPorCliente(cliente);
	}
	
	@Override
	public List<Servico> buscarServicosPorOficina(Oficina oficina) {
		return servicoRepository.listarServicoPorOficina(oficina);
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
	public void atualizarVeiculo(Veiculo veiculo) {
		servicoRepository.updateProduto(veiculo);
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
	public void deletarTodos(Veiculo veiculo) {
		
		List<Servico> servicos = servicoRepository.findAll();
		
		for(Servico serv: servicos){
			
			if(serv.getVeiculo().getId() == veiculo.getId()){
			
			servicoRepository.delete(serv);
			}
		}
		
	}
	
	public void inserirOrcamento(Orcamento orcamento){
		orcamentoRepository.save(orcamento);
	}

	@Override
	public void vistoriaPendente(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.VISTORIA_PENDENTE);
		inserir(servicoAtualizado);
	}

	@Override
	public void autorizacaoPendente(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.AUTORIZACAO_PENDENTE);
		inserir(servicoAtualizado);
	}

	@Override
	public void servicoAutorizado(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.SERVICO_AUTORIZADO);
		inserir(servicoAtualizado);
	}

	@Override
	public void servicoNaoAutorizado(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.SERVICO_NAO_AUTORIZADO);
		inserir(servicoAtualizado);
	}

	@Override
	public void aguardandoPecas(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_PECAS);
		inserir(servicoAtualizado);
	}

	@Override
	public void aguardandoCliente(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_CLIENTE);
		inserir(servicoAtualizado);
	}

	@Override
	public void emAndamento(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.EM_ANDAMENTO);
		inserir(servicoAtualizado);
	}

	@Override
	public void aguardandoComplemento(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_COMPLEMENTO);
		inserir(servicoAtualizado);
	}

	@Override
	public void finalizado(Integer id) {
		Servico servicoAtualizado = buscarPorId(id);
		servicoAtualizado.setStatus(EnumStatus.FINALIZADO);
		inserir(servicoAtualizado);
	}
	
}