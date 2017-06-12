package com.SGSRveiculo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.InfoExtraVeiculo;


@Repository
public interface InfoExtraVeiculoRepository extends JpaRepository<InfoExtraVeiculo, String>{
	
	@Query("SELECT i.kmTotal FROM InfoExtraVeiculo i WHERE i.id =:id_produto")
	Double getKmTotalVeiculo(@Param("id_produto") String id_produto);
}
