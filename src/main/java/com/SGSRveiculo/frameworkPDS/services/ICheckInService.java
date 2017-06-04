package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.CheckIn;


public interface ICheckInService {

	public void inserir(CheckIn checkIn);

	List<CheckIn> buscarCheckInPorId(Integer idServico);

}
