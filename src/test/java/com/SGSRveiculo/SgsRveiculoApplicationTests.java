package com.SGSRveiculo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SGSRveiculo.frameworkPDS.services.OficinaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SgsRveiculoApplicationTests {

	@Test
	public void contextLoads() {
		
		OficinaService oss = new OficinaService();
		
		
		oss.cadastrarPecasSite("http://www.triseteparts.com.br/busca/?q=", "filtro de ar");
		
	}

}
