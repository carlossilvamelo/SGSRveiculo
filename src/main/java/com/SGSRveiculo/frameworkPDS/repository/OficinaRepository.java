package com.SGSRveiculo.frameworkPDS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.Oficina;


@Repository
public interface OficinaRepository extends JpaRepository<Oficina, String>{

}
