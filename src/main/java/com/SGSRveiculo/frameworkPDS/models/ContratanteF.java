package com.SGSRveiculo.frameworkPDS.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat; 

@Entity
public class ContratanteF implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_contratante")
	private String id;
	private String nome;
	private String telefone;
	private String telefoneAlt;
	private String email;
	private String sexo;

	@OneToMany(mappedBy="contratante", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private List<ProdutoF> produto;
	
	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private EnderecoF endereco;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataNascimento;

	@OneToMany(mappedBy="contratante", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private List<ServicoF> servicos = new ArrayList<ServicoF>();
	
	
	

	public ContratanteF(){};
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefoneAlt() {
		return telefoneAlt;
	}
	public void setTelefoneAlt(String telefoneAlt) {
		this.telefoneAlt = telefoneAlt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public List<ServicoF> getServicos() {
		return servicos;
	}


	public void setServicos(List<ServicoF> servicos) {
		this.servicos = servicos;
	}
	
	public void adicionarServico(ServicoF servico) {
		this.servicos.add(servico);
	}

	public EnderecoF getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoF endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<ServicoF> getServico() {
		return servicos;
	}
	public void setServico() {
		this.servicos = new ArrayList<ServicoF>();
	}
	public void addServico(ServicoF servico){
		this.servicos.add(servico);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public List<ProdutoF> getProduto() {
		return produto;
	}
	public void setProduto() {
		this.produto = new ArrayList<ProdutoF>();
	}
	public void addProduto(ProdutoF produto){
		this.produto.add(produto);
	}
	


}