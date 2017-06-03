package com.SGSRveiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.SGSRveiculo.controller.HomeController;
import com.frameworkPDS.repository.ContratanteRepository;
import com.frameworkPDS.services.ContratanteService;
import com.frameworkPDS.services.ServicoService;


@SpringBootApplication
@ComponentScan(basePackages = "com.frameworkPDS")
public class SgsRveiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgsRveiculoApplication.class, args);
	}
}
