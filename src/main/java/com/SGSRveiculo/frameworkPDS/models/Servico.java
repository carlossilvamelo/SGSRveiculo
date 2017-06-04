package com.SGSRveiculo.frameworkPDS.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Servico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servico")
	private Integer id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_acompanhamento")
	private Acompanhamento acompanhamento;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_MarcaModelo")
	private MarcaModelo marcaModelo;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dataRequerimento;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar prazoFinal;

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="id_prestadora")
	private Prestadora prestadora;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="id_contratante")
	private Contratante contratante;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_produto")
	private Produto produto;
	
	private String notaFiscal;
	
	@OneToMany(mappedBy="servico",fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private List<Orcamento> orcamentos;

	private String descricao;
	private String obs;
	
	public Servico() {	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Acompanhamento getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(Acompanhamento acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public Date getDataRequerimento() {
		return dataRequerimento;
	}

	public void setDataRequerimento(Date dataRequerimento) {
		this.dataRequerimento = dataRequerimento;
	}

	public Calendar getPrazoFinal() {
		return prazoFinal;
	}

	public void setPrazoFinal(Calendar prazoFinal) {
		this.prazoFinal = prazoFinal;
	}

	public Prestadora getPrestadora() {
		return prestadora;
	}

	public void setPrestadora(Prestadora prestadora) {
		this.prestadora = prestadora;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	/*public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}*/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
	
}
