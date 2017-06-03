package com.SGSRveiculo.frameworkPDS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.ContratanteF;



@Transactional
@Repository
//Spring Data JPA creates an implementation on the fly
public interface ContratanteRepository extends JpaRepository<ContratanteF, String>{
	
	
}

