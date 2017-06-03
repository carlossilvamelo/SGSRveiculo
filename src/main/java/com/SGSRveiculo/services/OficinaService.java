package com.SGSRveiculo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SGSRveiculo.frameworkPDS.models.PrestadoraF;
import com.SGSRveiculo.frameworkPDS.services.PrestadoraService;
import com.SGSRveiculo.models.Oficina;

@Service
public class OficinaService extends PrestadoraService{
	
	public List<Oficina> buscarTodasOficinas(){
		List<PrestadoraF> prestadoras = super.buscarTodos();
		List<Oficina> oficinas = new ArrayList<Oficina>();
		
		for (PrestadoraF prestadora : prestadoras) {
			oficinas.add((Oficina) prestadora);
		}
		return oficinas;
	}
	
}
