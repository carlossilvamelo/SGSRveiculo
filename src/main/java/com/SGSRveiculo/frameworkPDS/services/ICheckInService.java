package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.CheckInF;


public interface ICheckInService {

	public void inserir(CheckInF checkIn);

	List<CheckInF> buscarCheckInPorId(Integer idServico);

}
