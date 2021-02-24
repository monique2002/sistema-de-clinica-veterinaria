package com.clinica.arcadenoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.sun.istack.NotNull;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String dataHora;
	
	@NotNull
	@Column(precision = 4, scale = 2)
	private double valorConsulta;
	
	@NotNull
	@Column(length = 30)
	private String modalidade;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Veterinario veterinario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Animal animal;

	public Consulta() {
		
	}
	
	public Consulta(String dataHora, double valorConsulta, String modalidade, Veterinario veterinario,
			Animal animal) {
		this.dataHora = dataHora;
		this.valorConsulta = valorConsulta;
		this.modalidade = modalidade;
		this.veterinario = veterinario;
		this.animal = animal;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDataHora() {
		return dataHora;
	}


	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}


	public double getValorConsulta() {
		return valorConsulta;
	}


	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}


	public Veterinario getVeterinario() {
		return veterinario;
	}


	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	@Override
	public String toString() {
		return "Consulta [id=" + id + ", dataHora=" + dataHora + ", valorConsulta=" + valorConsulta + ", modalidade="
				+ modalidade + "]";
	}


}
