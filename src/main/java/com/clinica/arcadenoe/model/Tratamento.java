package com.clinica.arcadenoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Tratamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Medicamento medicamento;
	
	@NotNull
	@Column(length = 15)
	private String horario;

	@NotNull
	@Column(length = 15)
	private String dosagem;
	
	@Column(length = 60)
	private String observacao;
	
	@OneToOne
	private Consulta consulta;
	
	public Tratamento() {
		
	}


	public Tratamento(Medicamento medicamento, String horario, String dosagem, String observacao, Consulta consulta) {
		this.medicamento = medicamento;
		this.horario = horario;
		this.dosagem = dosagem;
		this.observacao = observacao;
		this.consulta = consulta;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setLstMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	

	public Consulta getConsulta() {
		return consulta;
	}


	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}


	@Override
	public String toString() {
		return "Tratamento [id=" + id + ", horario=" + horario + ", dosagem=" + dosagem + ", observacao=" + observacao
				+ "]";
	}

	
	
	
	
}
