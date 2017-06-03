package com.SGSRveiculo.frameworkPDS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.EnderecoF;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoF, String>{
	
	
}
