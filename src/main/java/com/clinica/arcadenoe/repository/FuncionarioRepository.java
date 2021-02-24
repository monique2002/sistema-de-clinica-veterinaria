package com.clinica.arcadenoe.repository;

import org.springframework.data.repository.CrudRepository;

import com.clinica.arcadenoe.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	
	public Funcionario findByEmailAndSenha(String email, String senha);

}
