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
public class TipoUsuario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(length = 15)
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoUsuario")
	private List<Veterinario> lstVeterinario = new ArrayList<Veterinario>();

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoUsuario")
	private List<Funcionario> lstFuncionario = new ArrayList<Funcionario>();
	
	public TipoUsuario() {
		
	}
	

	public TipoUsuario(String nome) {
		this.nome = nome;
	}



	public TipoUsuario(int id) {
		this.id = id;
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


	public List<Veterinario> getLstVeterinario() {
		return lstVeterinario;
	}


	public void setLstVeterinario(List<Veterinario> lstVeterinario) {
		this.lstVeterinario = lstVeterinario;
	}


	public List<Funcionario> getLstFuncionario() {
		return lstFuncionario;
	}


	public void setLstFuncionario(List<Funcionario> lstFuncionario) {
		this.lstFuncionario = lstFuncionario;
	}


	@Override
	public String toString() {
		return "TipoUsuario [id=" + id + ", nome=" + nome + "]";
	}


	
	
	
}
