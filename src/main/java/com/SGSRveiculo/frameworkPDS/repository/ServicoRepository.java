package com.SGSRveiculo.frameworkPDS.repository;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.Cliente;
import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;



@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

	@Query("SELECT s FROM  Servico s WHERE s.cliente = :cliente")
	ArrayList<Servico> listarServicoPorCliente(@Param("cliente") Cliente cliente);
	
	@Query("SELECT s FROM  Servico s WHERE s.oficina = :oficina")
	ArrayList<Servico> listarServicoPorOficina(@Param("oficina") Oficina oficina);
	
	@Modifying
	@Query("UPDATE Servico s SET s.veiculo = '' WHERE s.veiculo =:veiculo")
	ArrayList<Servico> updateProduto(@Param("veiculo") Veiculo veiculo);
}

