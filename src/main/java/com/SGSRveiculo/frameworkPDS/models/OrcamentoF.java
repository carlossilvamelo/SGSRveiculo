package com.SGSRveiculo.frameworkPDS.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrcamentoF implements Serializable{
	

	private static final long serialVersionUID = -3329162767984686645L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_orcamento")
	private Long id;
	private Double precoMaoObra;
	private String obs;
	private Double valorAdicional;
	private Double descontoValor;
	private Integer descontoPorcentagem;
	
	public OrcamentoF() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Double getDescontoValor() {
		return descontoValor;
	}

	public void setDescontoValor(Double descontoValor) {
		this.descontoValor = descontoValor;
	}

	public Integer getDescontoPorcentagem() {
		return descontoPorcentagem;
	}

	public void setDescontoPorcentagem(Integer descontoPorcentagem) {
		this.descontoPorcentagem = descontoPorcentagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}


	public ServicoF getServico() {
		return servico;
	}

	public void setServico(ServicoF servico) {
		this.servico = servico;
	}

	@OneToMany(mappedBy="orcamento",fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<PecaF> pecasTroca;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_servico")
	private ServicoF servico;

	public Double getPrecoMaoObra() {
		return precoMaoObra;
	}

	public void setPrecoMaoObra(Double precoMaoObra) {
		this.precoMaoObra = precoMaoObra;
	}

	public List<PecaF> getPecasTroca() {
		return pecasTroca;
	}

	private void setPecasTroca(List<PecaF> pecasTroca) {
		this.pecasTroca = pecasTroca;
	}
	
	public void addPeca(PecaF peca){
		
		setPecasTroca(new ArrayList<PecaF>());
		pecasTroca.add(peca);
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
