package com.clinica.arcadenoe.repository;

import org.springframework.data.repository.CrudRepository;

import com.clinica.arcadenoe.model.Veterinario;

public interface VeterinarioRepository extends CrudRepository<Veterinario, Integer>{
	public Veterinario findByEmailAndSenha(String email, String senha);
}
