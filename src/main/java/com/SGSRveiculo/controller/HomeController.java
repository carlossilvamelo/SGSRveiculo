package com.SGSRveiculo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SGSRveiculo.frameworkPDS.repository.MarcaModeloRepository;
import com.SGSRveiculo.models.Cliente;
import com.SGSRveiculo.models.Oficina;
import com.SGSRveiculo.services.ClienteService;
import com.SGSRveiculo.services.OficinaService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired 
	MarcaModeloRepository mmRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private OficinaService oficinaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("index");
		/*
		ArrayList<CheckIn> lista = (ArrayList<CheckIn>) checkInService.buscarCheckInPorId(321321);
		for (CheckIn checkIn : lista) {
			System.out.println(checkIn.getDataHora()+"  "+checkIn.getAcao());
		}
		
		MarcaModelo mm;
		
		if(mmRepository.findAll().size() == 0){
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					mm = new MarcaModelo();
					mm.setMarca(EnumMarcasModelos.getMarcaById(i).toString());
					mm.setModelo(EnumMarcasModelos.getMarcaById(i).getModeloById(j));
					mmRepository.save(mm);
				}
			}
		}
		*/
        return mv;
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(String login, String senha){
		
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@GetMapping("/teste")
	public ModelAndView teste(){
		
		ModelAndView mv = new ModelAndView("teste");
		
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(String login, String senha,RedirectAttributes attributes, HttpSession session){
		
		ModelAndView mv;
		
		Cliente cliente = (Cliente) clienteService.buscarPorId(login);
		
		if(cliente != null){
			attributes.addFlashAttribute("message","Bem Vindo " + cliente.getNome());
			attributes.addFlashAttribute("cliente", cliente);
			session.setAttribute("usuario", cliente);
			mv = new ModelAndView("redirect:cliente");
		}
		else{
			Oficina oficina = (Oficina) oficinaService.buscarPorId(login);
			
			if(oficina != null){
				attributes.addFlashAttribute("message","Bem Vindo " + oficina.getNome());
				attributes.addFlashAttribute("oficina", oficina);
				session.setAttribute("usuario", oficina);
				mv = new ModelAndView("redirect:oficina");
			}
			
			else{
				mv = new ModelAndView("redirect:login");
				attributes.addFlashAttribute("message","Login incorreto ou não existe!");
			}
		}
		
		return null;
	}
	
	
}
