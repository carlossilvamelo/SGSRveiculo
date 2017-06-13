package com.SGSRveiculo.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SGSRveiculo.frameworkPDS.models.Cliente;
import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Orcamento;
import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;
import com.SGSRveiculo.frameworkPDS.services.ClienteService;
import com.SGSRveiculo.frameworkPDS.services.OficinaService;
import com.SGSRveiculo.frameworkPDS.services.ServicoService;
import com.SGSRveiculo.frameworkPDS.services.VeiculoService;
import com.SGSRveiculo.services.ListaPecas;
import com.SGSRveiculo.services.PecaService;


@Controller
@RequestMapping("/oficina")
@RequestScope
public class OficinaController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private OficinaService oficinaService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private ServicoService servicoService; 
	@Autowired
	private PecaService pecaService;
	@Autowired
	private ListaPecas pecas;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView oficina(Model model, HttpSession session){
		ModelAndView mv = new ModelAndView("oficina/oficina");
		
		Oficina oficina = (Oficina) session.getAttribute("usuario");
		List<Servico> listaServicos = servicoService.buscarServicosPorOficina(oficina);
		mv.addObject("listaServicos",listaServicos);
		
		return mv;
	}
	
	
	@GetMapping("/cadastro")
	public ModelAndView formCadastroOficina(){
		ModelAndView mv = new ModelAndView("/oficina/cadastro");
		Oficina oficina = new Oficina();
		mv.addObject("oficina", oficina);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView cadastroOficina(Oficina oficina, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/oficina/cadastro");
		oficinaService.inserir(oficina);
		mv.addObject("oficina", oficina);
		
		attributes.addFlashAttribute("message", "Oficina cadastrada com sucesso!");	
		return mv;
	}
	
	@RequestMapping("/todosServicos")
	public ModelAndView mostrarServicos(HttpSession session){
		
		ModelAndView mv = new ModelAndView("oficina/todosServicos");
		//descer para a camada de validação
		Oficina temp = (Oficina) session.getAttribute("usuario");
		Oficina oficina = oficinaService.buscarPorId(temp.getId());
		return mv;
	}
	
	@GetMapping("/novoServicoOficina")
	public ModelAndView cadastrarServico(HttpSession session){
		ModelAndView mv = new ModelAndView("servico/formServicoOficina");
		
		return mv;
	}
	
	@PostMapping("/novoServicoOficina")
	public ModelAndView cadastrarServico(Servico servico){
		
		ModelAndView mv = new ModelAndView("redirect:/oficina/");
		
		servicoService.inserir(servico);
		
		return mv;
	}
	
	@GetMapping("/novoVeiculo")
	public ModelAndView formVeiculo(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("oficina/formVeiculoOficina");

		Veiculo veiculo = new Veiculo();
		//List<String> marcas = veiculoService.listarMarcas();
		//mv.addObject("cores", EnumCores.values());
		//mv.addObject("marcas", marcas);
		mv.addObject("veiculo", veiculo);
		
		return mv;
	}
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos(String marca){
		
		//List<String> modelos = veiculoService.listarMarcaModelo(marca);
		
		//return modelos;
		return null;
		
	}
	
	@PostMapping("/novoVeiculo")
	public ModelAndView salvarVeiculo(Veiculo veiculo, HttpSession session){
		
		
		ModelAndView mv = new ModelAndView("oficina/formVeiculoOficina");
		
		//MarcaModelo m = veiculoService.listarMarcaModelo(veiculo.getMarcaModelo().getMarca(), veiculo.getMarcaModelo().getModelo());
		
		//veiculo.setMarcaModelo(m);
		
		//veiculo.setCliente(cliente);
		//cliente.addVeiculo(veiculo);
		
		//clienteService.inserir(cliente);
		
		return mv;
	}
	
	@GetMapping("/novoCliente")
	public ModelAndView formNovoCliente(){
		ModelAndView mv = new ModelAndView("/oficina/formClienteOficina");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/novoCliente")
	public ModelAndView cadastroClienteOficina(Cliente cliente, HttpSession session){
		ModelAndView mv = new ModelAndView("redirect:/oficina/");
		clienteService.inserir(cliente);
		
		return mv;
	}
	
	
	@GetMapping("/addPeca")
	public @ResponseBody Collection<Peca> addPeca(Long idPeca){
		
		Peca peca = pecaService.buscarPorId(idPeca);
		//objeto que irá armazenar as peças que vão sendo inseridas para gerar o orçamento
		pecas.add(peca);
		
		return pecas.getPecas();
	}
	
	
	@GetMapping("/gerarOrcamento")
	public ModelAndView acessarOrcamento(HttpSession session,@RequestParam(name="id", required=true) Integer idServico){
		
		ModelAndView mv = new ModelAndView("/oficina/gerarOrcamento");
		
		mv.addObject("servico", servicoService.buscarPorId(idServico));
		mv.addObject("listaPeca", pecaService.listarPecas());
		
		return mv;
		
	}
	
	@PostMapping("/gerarOrcamento")
	public ModelAndView gerarOrcamento(@RequestParam(name="id", required=true)Integer idServico){
		
		ModelAndView mv = new ModelAndView("redirect:/oficina");
		
		Orcamento orcamento = new Orcamento();
		Servico servico = servicoService.buscarPorId(idServico);
		String msg = "";
		orcamento.setServico(servico);
		
		oficinaService.gerarOrcamento(pecas.getPecas());
		
		for(Peca peca: pecas.getPecas()){
			
			System.out.println(peca.getNome() + " para o serviço "+ servico.getDescricao());
		}
		
		servico.setOrcamentos();
		servico.addOrcamentos(orcamento);
		
		if(servico.getOrcamentos().isEmpty()){
			msg += "Não foi possível criar o orçamento";
		}
		msg += "O orçamento foi registrado com sucesso";
		
		mv.addObject("servico", servicoService.buscarPorId(idServico));
		mv.addObject("listaPeca", pecaService.listarPecas());
		mv.addObject("orcamento", new Orcamento());
		mv.addObject("msg", msg);
		
		pecas.limpar();
		return mv;
		
	}
	
	@GetMapping("/estoque")
	public ModelAndView buscarPeca(){
		
		ModelAndView mv = new ModelAndView("/oficina/estoque");
		
		mv.addObject("listaPeca", pecaService.listarPecas());
		
		return mv;
		
	}
	
	@GetMapping("/cadastrarPecasSite")
	public ModelAndView cadastrarPecasSite(Integer site, String peca){
		
		ModelAndView mv = new ModelAndView("redirect:/oficina/estoque");
		
		if(site == 1){
			
			oficinaService.cadastrarPecasSite("http://www.triseteparts.com.br/busca/?q=", peca);
		}
		
		
		return mv;
		
	}
	
	@GetMapping("/novaPeca")
	public ModelAndView novaPeca(){
		
		ModelAndView mv = new ModelAndView("/oficina/novaPeca");
	
		return mv;
		
	}
	
	@GetMapping("/buscarPeca")
	public ModelAndView buscarPeca(Integer site, String peca){
		
		ModelAndView mv = new ModelAndView("/oficina/novaPeca");
		List<Peca> listaPecas = null;
		
		if(site == 1){
			
			listaPecas = oficinaService.buscarPecaSite("http://www.triseteparts.com.br/busca/?q=", peca);
		}
		
		if(!listaPecas.isEmpty()){
			mv.addObject("listaPeca", listaPecas);
		}else{
			mv.addObject("msg", "Peças não encontradas");
			
		}
		return mv;
		
	}
	
	@PostMapping("/buscarPeca")
	public @ResponseBody Peca buscarPeca(Peca peca){
		
		System.out.println(peca.getNome());
		pecaService.cadastrarPeca(peca);
		
		
		return peca;
		
	}

}
