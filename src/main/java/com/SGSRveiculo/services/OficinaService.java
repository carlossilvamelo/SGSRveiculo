package com.SGSRveiculo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SGSRveiculo.models.Oficina;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.frameworkPDS.models.PrestadoraF;
import com.frameworkPDS.services.PrestadoraService;

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
