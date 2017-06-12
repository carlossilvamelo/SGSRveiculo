package com.SGSRveiculo.frameworkPDS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.Cliente;



@Transactional
@Repository
//Spring Data JPA creates an implementation on the fly
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	
}

