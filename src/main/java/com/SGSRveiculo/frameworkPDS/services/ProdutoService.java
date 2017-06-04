package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.MarcaModelo;
import com.SGSRveiculo.frameworkPDS.models.Produto;
import com.SGSRveiculo.frameworkPDS.repository.MarcaModeloRepository;
import com.SGSRveiculo.frameworkPDS.repository.ProdutoRepository;


@Service
public class ProdutoService implements IProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private MarcaModeloRepository modeloRepository;
	

	@Override
	public void inserir(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public Produto buscarPorId(String id) {
		return produtoRepository.getOne(id);
	}
	@Override
	public void deletarTodos(Produto produto) {
		
		/*for(Servico serv: produto.getServicos()){
			servicoRepository.delete(serv);
		}*/
		
	}
	@Override
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
	
	@Override
	public void deletar(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@Override
	public void deletePorId(String idProduto) {
		
		produtoRepository.deletePorId(idProduto);
	}
	
	@Override
	public void deleteAlertasProduto(Produto produto) {
		//TODO criar esse método
		
		//dataFacade.getAlertaRepository().deleteByTipoAlerta(veiculo);
	}

	@Override
	public List<String> buscarModelosPorMarca(String marca) {
		// TODO Auto-generated method stub
		return modeloRepository.buscarModelosPorMarca(marca);
	}

	@Override
	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo) {
		// TODO Auto-generated method stub
		return modeloRepository.buscarPorMarcaModelo(marca, modelo);
	}

	@Override
	public List<String> buscarModelos() {
		// TODO Auto-generated method stub
		return modeloRepository.buscarModelos();
	}

	
	

}
