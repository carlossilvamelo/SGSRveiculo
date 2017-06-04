package com.SGSRveiculo.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.CheckIn;
import com.SGSRveiculo.frameworkPDS.repository.CheckInRepository;



@Service
public class CheckInService implements ICheckInService{
	
	@Autowired
	private CheckInRepository checkInRepository;

	@Override
	public void inserir(CheckIn checkIn) {
		try {
			checkInRepository.save(checkIn);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados. [checkIn]");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CheckIn> buscarCheckInPorId(Integer idServico) {
		
		return checkInRepository.listarCheckInPorServico(idServico);
	}
	
}
