package com.SGSRveiculo.services.busca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.services.busca.Busca;


public class BuscaPecaSite extends Busca {

	private Document documento;
	private String url;
	
	public BuscaPecaSite(String url, String nomePeca){
		
		this.url = criarUrl(url, nomePeca);
		pecas = new ArrayList<Peca>();
		
		try {

			documento = Jsoup.connect(this.url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public synchronized String criarUrl(String url, String nomePeca){
		
		//String nomeTemp = nomePeca.replace(" ", "-");
		
		return url+nomePeca;
	}
	
	public synchronized List<Peca> buscaPeca(){
		
		try {

			documento = Jsoup.connect(this.url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.wait(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Elements htmlElements = documento.getElementsByClass("box-produto");
		
		List<Elements> childrenEl = new ArrayList<Elements>();
		List<Element> lista = new ArrayList<Element>();
		
	
		for(Element el: htmlElements){
			
			childrenEl.add(el.children());
		}
		
		int soma = 0;
		
		int count = 0;
		
		for(int i = 1;i < childrenEl.size();i++){
			
			Peca peca = new Peca();
			for (Element element : childrenEl.get(i)) {
				
				
				for (Element el : element.children()) {
					
					//System.out.println(el.html());
					for(Element e:el.getElementsByClass("nome")){
						System.out.println(e.text());
						if(e.text().length() != 0){
							peca.setNome(e.text());
							soma ++;
						}
						
					}
					for(Element e:el.getElementsByClass("avaliacoes")){
					
						
						if(e.text().length() != 0){
							// limpa o texto
							String[] test = new String[2];
							test = e.text().split(" ");
							peca.setAvaliacao(Integer.parseInt(test[0].replace("(", "")));
							soma ++;
						}
					}
					String[] precoTemp = new String[6];
					for(Element e:el.getElementsByClass("preco")){
												
						precoTemp = e.getElementsByIndexEquals(0).text().split(" ");
						
							if(precoTemp.length != 0){
								
								String valor = precoTemp[1].replace("R$", "").trim();
								System.out.println(valor);
								if(valor.contains("indisponível")){
									peca.setPreco("0.0");
								}else{
									peca.setPreco(valor.replace(".", "").replace(",", "."));
									
								}
								soma ++;
							}
						
					}		
					//significa que já preencheu os três campos
					if(soma == 3){
						
						System.out.println(peca);
						pecas.add(peca);
						count++;
						
						soma = 0;
					}
					
				}
			}
		}
		

		return pecas;
	}
	

}
