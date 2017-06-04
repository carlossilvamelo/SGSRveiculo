package com.SGSRveiculo.frameworkPDS.services;


import java.util.List;

import com.SGSRveiculo.frameworkPDS.models.MarcaModelo;

public interface IMarcaModelo {

	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo);
	public List<String> buscarModelosPorMarca(String marca);
}
