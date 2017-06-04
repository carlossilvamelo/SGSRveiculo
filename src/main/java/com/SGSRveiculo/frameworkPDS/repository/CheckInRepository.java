package com.SGSRveiculo.frameworkPDS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.CheckIn;



@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer>{

	
	@Query("SELECT c FROM CheckIn c WHERE c.id =:id ")
	public List<CheckIn> listarCheckInPorServico(@Param("id")Integer id);

}
