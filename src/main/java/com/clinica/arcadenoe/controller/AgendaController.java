package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.arcadenoe.model.Consulta;
import com.clinica.arcadenoe.model.Veterinario;
import com.clinica.arcadenoe.repository.ConsultaRepository;

@Controller
@RequestMapping("veterinario/agenda/")
public class AgendaController {

	@Autowired
	private ConsultaRepository consultaRepos;
	
	private int idVet;
	
	@RequestMapping("{id}")
	public String salvaId(@PathVariable int id, Model  model) {
	
		idVet = id;
		
		model.addAttribute("consultas", retornaConsultas());
		
	
		return "veterinario/agenda";
	}
	
	private List<Consulta> retornaConsultas() {
		
		var consulta = new ArrayList<Consulta>();
	
		var veterinario = new Veterinario(idVet);
		
		consultaRepos.findByVeterinario(veterinario).forEach(c->{
			consulta.add(c);
			
		});
		
		return consulta;
	}
	
	
	
}
