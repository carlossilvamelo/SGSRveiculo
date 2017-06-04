package com.SGSRveiculo.frameworkPDS.repository;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.Contratante;
import com.SGSRveiculo.frameworkPDS.models.Prestadora;
import com.SGSRveiculo.frameworkPDS.models.Produto;
import com.SGSRveiculo.frameworkPDS.models.Servico;




@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

	@Query("SELECT s FROM  Servico s WHERE s.contratante = :contratante")
	ArrayList<Servico> listarServicoPorContratante(@Param("contratante") Contratante contratante);
	
	@Query("SELECT s FROM  Servico s WHERE s.prestadora = :prestadora")
	ArrayList<Servico> listarServicoPorPrestadora(@Param("prestadora") Prestadora prestadora);
	
	@Modifying
	@Query("UPDATE Servico s SET s.produto = '' WHERE s.produto =:produto")
	ArrayList<Servico> updateProduto(@Param("produto") Produto produto);
}

