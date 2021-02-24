package com.clinica.arcadenoe.model;

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
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Animal {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int id;
		
		@NotNull
		@Column (length = 15)
		private String nome;
		
		@NotNull
		@Column (length = 60)
		private String raca;
		
		@Column (length = 2)
		private int anoIdade;
		
		@Column (length = 2)
		private int mesIdade;
		
		@NotNull
		@Column (length = 15)
		private String cpfResponsavel;
		
		@NotNull
		@Column (length = 60)
		private String nomeResponsavel;

		@NotNull
		@Column (length = 15)
		private String telResponsavel;
		
		@NotNull
		@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(nullable = false)
		private Endereco endereco;
		
		@NotNull
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(nullable = false)
		private Especie especie;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "animal")
		private List<Consulta> lstConsultas = new ArrayList<Consulta>();
		
		
		public Animal() {
			
		}

	
		public Animal(int id, String nome, String raca, int anoIdade, int mesIdade, String cpfResponsavel,
				String nomeResponsavel, String telResponsavel, Endereco endereco, Especie especie) {
			this.id = id;
			this.nome = nome;
			this.raca = raca;
			this.anoIdade = anoIdade;
			this.mesIdade = mesIdade;
			this.cpfResponsavel = cpfResponsavel;
			this.nomeResponsavel = nomeResponsavel;
			this.telResponsavel = telResponsavel;
			this.endereco = endereco;
			this.especie = especie;
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

		public String getRaca() {
			return raca;
		}

		public void setRaca(String raca) {
			this.raca = raca;
		}

		public int getAnoIdade() {
			return anoIdade;
		}

		public void setAnoIdade(int anoIdade) {
			this.anoIdade = anoIdade;
		}

		public int getMesIdade() {
			return mesIdade;
		}

		public void setMesIdade(int mesIdade) {
			this.mesIdade = mesIdade;
		}

		public String getCpfResponsavel() {
			return cpfResponsavel;
		}

		public void setCpfResponsavel(String cpfResponsavel) {
			this.cpfResponsavel = cpfResponsavel;
		}

		public String getNomeResponsavel() {
			return nomeResponsavel;
		}

		public void setNomeResponsavel(String nomeResponsavel) {
			this.nomeResponsavel = nomeResponsavel;
		}

		public String getTelResponsavel() {
			return telResponsavel;
		}

		public void setTelResponsavel(String telResponsavel) {
			this.telResponsavel = telResponsavel;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public Especie getEspecie() {
			return especie;
		}

		public void setEspecie(Especie especie) {
			this.especie = especie;
		}

		public List<Consulta> getLstConsultas() {
			return lstConsultas;
		}

		public void setLstConsultas(List<Consulta> lstConsultas) {
			this.lstConsultas = lstConsultas;
		}

		@Override
		public String toString() {
			return "Animal [id=" + id + ", nome=" + nome + ", raca=" + raca + ", anoIdade=" + anoIdade + ", mesIdade="
					+ mesIdade + ", cpfResponsavel=" + cpfResponsavel + ", nomeResponsavel=" + nomeResponsavel
					+ ", telResponsavel=" + telResponsavel + "]";
		}
		
}
