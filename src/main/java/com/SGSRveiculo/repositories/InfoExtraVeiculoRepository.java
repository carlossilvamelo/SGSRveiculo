package com.SGSRveiculo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.models.InfoExtraVeiculo;

@Repository
public interface InfoExtraVeiculoRepository extends JpaRepository<InfoExtraVeiculo, String>{
	
	@Query("SELECT i.kmTotal FROM InfoExtraVeiculo i WHERE i.id =:chassi")
	Double getKmTotalVeiculo(@Param("chassi") String chassi);
}
