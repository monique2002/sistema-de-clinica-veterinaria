package com.clinica.arcadenoe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clinica.arcadenoe.model.Consulta;
import com.clinica.arcadenoe.model.Veterinario;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{
	public Consulta findByDataHoraAndVeterinario(String dataHora, Veterinario vet);
	
	public List<Consulta> findByVeterinario(Veterinario id);
}
