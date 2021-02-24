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
@RequestMapping("veterinario/")
public class HomeControllerVet {

	@Autowired
	private ConsultaRepository consultaRepos;
	
	private int idVet;
	
	@RequestMapping("{id}")
	public String salvaId(@PathVariable int id) {
	
		idVet = id;
	
		return "veterinario/homeVeterinario";
	}
	
	@RequestMapping("carrega")
	public String carrega( ){
	

	
		return "veterinario/homeVeterinario";
	}
	
	@RequestMapping("agenda")
	public String carregaAgenda() {
		
		
		return "redirect:/veterinario/agenda/"+idVet;
		
		
	}
	

	
	
	
}
