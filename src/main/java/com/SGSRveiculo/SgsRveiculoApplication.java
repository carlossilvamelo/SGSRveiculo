package com.SGSRveiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.SGSRveiculo.controller.HomeController;


@SpringBootApplication
@ComponentScan(basePackageClasses={HomeController.class})
public class SgsRveiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgsRveiculoApplication.class, args);
	}
}
