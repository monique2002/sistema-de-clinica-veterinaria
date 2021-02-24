package com.clinica.arcadenoe.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.sun.istack.NotNull;

@Entity
public class Veterinario {
	
	@NotNull
	@Id
	private int crvm;
	
	@NotNull
	@Column (length = 60)
	private String nome;
	
	@NotNull
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Endereco endereco;
	
	@NotNull
	@Column(length = 14)
	private String telefone;
	
	@NotNull
	@Column(length = 60)
	private String email;
	
	@NotNull
	@Column(length = 10)
	private String senha;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinario")
	List<Consulta> lstConsulta = new ArrayList<Consulta>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoUsuario tipoUsuario;
	
	public Veterinario() {
		
	}

	
	public Veterinario(int crvm, String nome, Endereco endereco, String telefone, String email, String senha) {
	
		this.crvm = crvm;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	

	}

	public Veterinario(int crvm) {
		this.crvm = crvm;
	}


	public int getCrvm() {
		return crvm;
	}

	public void setCrvm(int crvm) {
		this.crvm = crvm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
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


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<Consulta> getLstConsulta() {
		return lstConsulta;
	}

	public void setLstConsulta(List<Consulta> lstConsulta) {
		this.lstConsulta = lstConsulta;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Veterinario [crvm=" + crvm + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", email=" + email + ", senha=" + senha + "]";
	}
	

	
	
	
}
