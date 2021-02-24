package com.clinica.arcadenoe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.sun.istack.NotNull;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(length = 60)
	private String email;
	
	@NotNull
	@Column(length = 10)
	private String senha;
	
	@NotNull
	@Column(length = 60)
	private String nome;
	
	@NotNull
	@Column(length = 14)
	private String cpf;
	
	@NotNull
	private LocalDate nascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoUsuario tipoUsuario;

	public Funcionario() {
		
	}

	public Funcionario(String email, String senha, String nome, String cpf, LocalDate nascimento,
			TipoUsuario tipoUsuario) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.tipoUsuario = tipoUsuario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getNascimento() {
		return nascimento;
	}


	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf
				+ ", nascimento=" + nascimento + "]";
	}
	
	
	
	
	
}
