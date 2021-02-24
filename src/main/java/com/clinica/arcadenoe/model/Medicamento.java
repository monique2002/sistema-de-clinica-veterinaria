package com.clinica.arcadenoe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column (length = 30)
	private String nome;
	
	@NotNull
	@Column (length = 60)
	private String contraIndicacao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicamento")
	private List<Tratamento> lstTratamento = new ArrayList<Tratamento>();

	public Medicamento() {
		
	}

	
	public Medicamento(String nome, String contraIndicacao) {
		this.nome = nome;
		this.contraIndicacao = contraIndicacao;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContraIndicacao() {
		return contraIndicacao;
	}

	public void setContraIndicacao(String contraIndicacao) {
		this.contraIndicacao = contraIndicacao;
	}

	public List<Tratamento> getLstTratamento() {
		return lstTratamento;
	}

	public void setLstTratamento(List<Tratamento> lstTratamento) {
		this.lstTratamento = lstTratamento;
	}

	
	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nome=" + nome + ", contra indicação=" + contraIndicacao + "]";
	}
		
}
