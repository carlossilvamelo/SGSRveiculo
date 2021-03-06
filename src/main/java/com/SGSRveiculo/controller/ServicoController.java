package com.SGSRveiculo.controller;


import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SGSRveiculo.enumeracoes.EnumCores;
import com.SGSRveiculo.enumeracoes.EnumStatus;
import com.SGSRveiculo.frameworkPDS.models.CheckIn;
import com.SGSRveiculo.frameworkPDS.models.Cliente;
import com.SGSRveiculo.frameworkPDS.models.Oficina;
import com.SGSRveiculo.frameworkPDS.models.Pagamentos;
import com.SGSRveiculo.frameworkPDS.models.Peca;
import com.SGSRveiculo.frameworkPDS.models.Servico;
import com.SGSRveiculo.frameworkPDS.models.Veiculo;
import com.SGSRveiculo.frameworkPDS.services.ClienteService;
import com.SGSRveiculo.frameworkPDS.services.OficinaService;
import com.SGSRveiculo.frameworkPDS.services.PagamentosService;
import com.SGSRveiculo.frameworkPDS.services.ServicoService;
import com.SGSRveiculo.frameworkPDS.services.VeiculoService;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ServicoService servicoService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private OficinaService oficinaService;
	@Autowired
	private PagamentosService pagamentosService;

	@GetMapping("/novoServico")
	public ModelAndView formServico(@RequestParam(name="id", required=true) String id, HttpSession session, String descricao){

		ModelAndView mv = new ModelAndView("/servico/formServico");
		Servico servico = new Servico();
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		Cliente temp = (Cliente) clienteService.buscarPorId(cliente.getId());
		
		List<Veiculo> veiculos = temp.getVeiculo();
		List<Oficina> oficinas = oficinaService.buscarTodasOficinas();
		
		
		
		if(descricao != null){
			servico.setDescricao(descricao);
		}
		
		mv.addObject("servico", servico);
		mv.addObject("veiculos", veiculos);
		mv.addObject("oficinas", oficinas);
		
		return mv;
	}

	@PostMapping("/novoServico")
	public ModelAndView cadastrarServico(Servico servico, HttpSession session, RedirectAttributes attributes){

		ModelAndView mv = new ModelAndView("redirect:/cliente");
		Cliente tmp = (Cliente) session.getAttribute("usuario");
		Cliente cliente = (Cliente) clienteService.buscarPorId(tmp.getId());

		servico.setStatus(EnumStatus.PRE_DIAGNOSTICO);
		servico.setOficina(oficinaService.buscarPorId(servico.getOficina().getId()));
		servico.setVeiculo(veiculoService.buscarPorId(servico.getVeiculo().getId()));
		servico.setCliente(cliente);

		
		cliente.addServico(servico);
		
		servicoService.inserir(servico);
		attributes.addAttribute("message", "nova visita marcada!");

		return mv;
		
	}
	
	@GetMapping("/novoServicoOficina")
	public ModelAndView formServicoOficina(@RequestParam(name="id", required=true) String id, HttpSession session, String descricao){

		ModelAndView mv = new ModelAndView("/servico/formServicoOficina");
		Servico servico = new Servico();
		
		//Pegando informações para veículo
		List<String> marcas = veiculoService.buscarMarcas();
		mv.addObject("cores", EnumCores.values());
		mv.addObject("marcas", marcas);
		
		mv.addObject("servico", servico);
		
		return mv;
	}
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos(String marca){
		
		List<String> modelos = veiculoService.buscarModelosPorMarca(marca);
		
		return modelos;
	}
	
	@PostMapping("/novoServicoOficina")
	public ModelAndView cadastrarServicoOficina(Servico servico, HttpSession session, RedirectAttributes attributes){

		ModelAndView mv = new ModelAndView("redirect:/oficina");
		Oficina tmp = (Oficina) session.getAttribute("usuario");
		Oficina oficina = oficinaService.buscarPorId(tmp.getId());

		servico.setStatus(EnumStatus.PRE_DIAGNOSTICO);
		servico.setOficina(oficina);
		
		Cliente cliente = (Cliente) clienteService.buscarPorId(servico.getCliente().getId());
		
		if(cliente == null){
			attributes.addAttribute("message", "Cliente não cadastrado.");
			System.out.println("o cliente não está cadastrado");
			return mv;
		}
		else{
			Veiculo veiculoAtual = null;
			List<Veiculo> veiculos = cliente.getVeiculo();
			for (int i = 0; i < veiculos.size(); i++) {
				if(veiculos.get(i).getId().equals(servico.getVeiculo().getId())){
					veiculoAtual = veiculoService.buscarPorId(veiculos.get(i).getId());
				}
			}
			
			if(veiculoAtual == null){
				attributes.addFlashAttribute("message", "Carro não cadastrado.");
				System.out.println("o carro não está cadastrado");
				return mv;
			}
			
			servico.setCliente(cliente);
			servico.setVeiculo(veiculoAtual);
			oficina.addServico(servico);
			cliente.addServico(servico);
			servicoService.inserir(servico);
		}
		
		
		/*System.out.println("Veiculo: " + servico.getVeiculo().getNumeroChassi());
		cliente.addServico(servico);
		servico.setResponsavel(cliente);

		servicoService.inserir(servico);
		attributes.addAttribute("message", "Nova visita marcada!");*/

		return mv;

	}
	
	@GetMapping("/realizarPagamento")
	public ModelAndView realizarPagamentoForm(@RequestParam(name="id", required=true) Integer id){
		
		ModelAndView mv = new ModelAndView("pagamentos/cartaoCredito");
		Servico servico = servicoService.buscarPorId(id);
		
		mv.addObject("servico", servico);
		return mv;
		
	}
	
	@GetMapping("/visualizarPagamento")
	public ModelAndView mostrarInfoPagamentoForm(@RequestParam(name="id", required=true) Integer id){
		
		ModelAndView mv = new ModelAndView("pagamentos/relatorioPagamento");
		Servico servico = servicoService.buscarPorId(id);
		
		mv.addObject("servico", servico);
		return mv;
		
	}
	
	@PostMapping("/processar")
	public ModelAndView realizarPagamento(@RequestParam(name="id", required=true) Integer id,
			String nome, String numeroC1, String numeroC2,String numeroC3, String numeroC4,
			String codigoSeguranca,HttpSession session){
		Servico servico = servicoService.buscarPorId(id);
		
		servico.getOrcamento().setPago(true);
		ModelAndView mv = new ModelAndView("redirect:/cliente");

		Pagamentos pagamento = new Pagamentos();
		pagamentosService.processarPagamentoCredito(pagamento, servico);
		
		servicoService.inserir(servico);
		mv.addObject("servico", servico);
		return mv;
		
	}
	
	
	

	@GetMapping("/relatorio")
	public ModelAndView relatorio(@RequestParam(name="id", required=true) Integer id){
		
		ModelAndView mv = new ModelAndView("/servico/relatorioServico");
		
		Servico servico = (Servico) servicoService.buscarPorId(id);
		mv.addObject("servico",servico);
		
		return mv;
		
	}
	
	@GetMapping("/pecaSite")
	public List<Peca> buscarPeca(String nomePeca){
		
		
		oficinaService.cadastrarPecasSite("http://www.triseteparts.com.br/busca/?q=", nomePeca);
		
		return null;
		
	}
	
	@GetMapping("/aprovarServico")
	public ModelAndView aprovarServico(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/cliente");		
		servicoService.servicoAutorizado(id);
		return mv;
	}
	
	@GetMapping("/aprovarServicoAdmin")
	public ModelAndView aprovarServicoAdmin(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.servicoAutorizado(id);
		return mv;
	}
	
	@GetMapping("/vistoriaPendente")
	public ModelAndView vistoriaPendente(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.vistoriaPendente(id);
		return mv;
	}
	
	@GetMapping("/autorizacaoPendente")
	public ModelAndView autorizacaoPendente(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.autorizacaoPendente(id);
		return mv;
	}
	
	@GetMapping("/naoAutorizado")
	public ModelAndView naoAutorizado(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.vistoriaPendente(id);
		return mv;
	}
	
	@GetMapping("/aguardandoPecas")
	public ModelAndView aguardandoPecas(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.aguardandoPecas(id);
		return mv;
	}
	
	@GetMapping("/aguardandoCliente")
	public ModelAndView aguardandoCliente(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.aguardandoCliente(id);
		return mv;
	}
	
	@GetMapping("/emAndamento")
	public ModelAndView emAndamento(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.emAndamento(id);
		return mv;
	}
	
	@GetMapping("/aguardandoComplemento")
	public ModelAndView aguardandoComplemento(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.aguardandoComplemento(id);
		return mv;
	}
	
	@GetMapping("/finalizado")
	public ModelAndView finalizado(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.finalizado(id);
		return mv;
	}
	
	@GetMapping("/acompanhamento")
	public ModelAndView acompanhamento(@RequestParam(name="id", required=true) Integer id){
		
		ModelAndView mv = new ModelAndView("/servico/acompanhamento");	
		
		Servico servico =  (Servico) servicoService.buscarPorId(id);
		List<CheckIn> lista = null;
		
		
		
		if(servico != null){
			
			if(servico.getAcompanhamento() !=  null){
				lista = servico.getAcompanhamento().getCheckIns();
				
				if(lista.isEmpty()){
					
					mv.addObject("msg", "Não há informações sobre o andamento do serviço nesse momento!");
					
				}else{
					
					mv.addObject("lista", lista);
				}
			}else{
				mv.addObject("msg", "Não há informações sobre o andamento do serviço nesse momento!");
			}
				
		}
		
		return mv;
	}
	
	
	@GetMapping("/finalizar")
	public ModelAndView finalizarServico(@RequestParam(name="id", required=true) Integer id, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente");	
		
		//verifica se chegou no checkin de serviço finalizado para remover o servico
		servicoService.verificarServico(id);
		attributes.addAttribute("msg", "Serviço finalizado !");

		return mv;
	}

	
}
