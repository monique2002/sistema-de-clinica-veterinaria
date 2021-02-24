package com.clinica.arcadenoe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;



@Entity
public class Especie {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(length = 60)
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especie")
	private List<Animal> lstAnimal = new ArrayList<Animal>();
	
	public Especie() {
	
	}
	
	public Especie( String nome) {
		this.nome = nome;
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

	public List<Animal> getLstAnimal() {
		return lstAnimal;
	}

	public void setLstAnimal(List<Animal> lstAnimal) {
		this.lstAnimal = lstAnimal;
	}


	@Override
	public String toString() {
		return "Especie [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
