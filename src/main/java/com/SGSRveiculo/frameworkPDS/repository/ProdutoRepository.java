package com.SGSRveiculo.frameworkPDS.repository;

import java.util.ArrayList;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.ProdutoF;


@Transactional
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoF, String>{
	
	
	@Query("SELECT p FROM  ProdutoF p WHERE p.id = :id")
	ArrayList<ProdutoF> listarPorId(@Param("id") String id);
	
	@Modifying
	@Query("DELETE FROM ProdutoF p WHERE p.id = :id")
	void deletePorId(@Param("id") String id);

}
