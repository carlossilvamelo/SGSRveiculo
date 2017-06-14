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

import com.SGSRveiculo.enumeracoes.EnumStatus;


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
	
	private EnumStatus status;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dataRequerimento;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar prazoFinal;

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="id_oficina")
	private Oficina oficina;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;
	
	private String notaFiscal;
	
	@OneToOne(mappedBy="servico",fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private Orcamento orcamento;

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

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

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

	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	
	
}