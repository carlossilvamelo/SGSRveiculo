package com.SGSRveiculo.frameworkPDS.repository;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.ContratanteF;
import com.SGSRveiculo.frameworkPDS.models.PrestadoraF;
import com.SGSRveiculo.frameworkPDS.models.ProdutoF;
import com.SGSRveiculo.frameworkPDS.models.ServicoF;




@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<ServicoF, Integer>{

	@Query("SELECT s FROM  ServicoF s WHERE s.contratante = :contratante")
	ArrayList<ServicoF> listarServicoPorContratante(@Param("contratante") ContratanteF contratante);
	
	@Query("SELECT s FROM  ServicoF s WHERE s.prestadora = :prestadora")
	ArrayList<ServicoF> listarServicoPorPrestadora(@Param("prestadora") PrestadoraF prestadora);
	
	@Modifying
	@Query("UPDATE ServicoF s SET s.produto = '' WHERE s.produto =:produto")
	ArrayList<ServicoF> updateProduto(@Param("produto") ProdutoF produto);
}

