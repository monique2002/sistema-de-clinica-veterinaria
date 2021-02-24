package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.arcadenoe.model.Consulta;
import com.clinica.arcadenoe.model.Especie;
import com.clinica.arcadenoe.model.Exame;
import com.clinica.arcadenoe.model.Medicamento;
import com.clinica.arcadenoe.model.Tratamento;
import com.clinica.arcadenoe.model.Veterinario;
import com.clinica.arcadenoe.repository.ConsultaRepository;
import com.clinica.arcadenoe.repository.ExameRepository;
import com.clinica.arcadenoe.repository.MedicamentoRepository;
import com.clinica.arcadenoe.repository.TratamentoRepository;

@Controller
@RequestMapping("veterinario/tratamento")
public class TratamentoController {

	@Autowired
	private TratamentoRepository tratamentoRepos;
	
	@Autowired
	private MedicamentoRepository medicamentoRepos;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	private Integer idVet;
	
	@RequestMapping("carrega")
	public String carregaExame(Model model) {
		
		model.addAttribute("tratamentos", retornaTratamento());
		
		return "veterinario/tratamento";
		
	}
	
	@RequestMapping("cadastrar")
	public String cadastra(Model model) {
		
		model.addAttribute("tratamento", new Tratamento());
		model.addAttribute("medicamentos", retornaMedicamento());
		model.addAttribute("consultas", retornaConsulta());
		
		return "veterinario/tratamentoCadastro";
	}
	
	@RequestMapping("cadastrar/salva")
	public String salva(Tratamento tratamento) {
	
		tratamentoRepos.save(tratamento);

		return "redirect:/veterinario/tratamento/carrega";
	}
	
	@RequestMapping("salvaId/{id}")
	public String salvaId(@PathVariable int id) {
	
		idVet = id;

		return "redirect:/veterinario/{id}";
	}
	
	
	private List<Tratamento> retornaTratamento() {
		var tratamentos = new ArrayList<Tratamento>();

		tratamentoRepos.findAll().forEach( t -> {
			tratamentos.add(t);
			
		});


		return tratamentos;
	}

	private List<Medicamento> retornaMedicamento(){

		var medicamentos = new ArrayList<Medicamento>();

		medicamentoRepos.findAll().forEach( m -> {
			medicamentos.add(m);
			
		});


		return medicamentos;

	}
	

	private List<Consulta> retornaConsulta(){

		var consulta = new ArrayList<Consulta>();
		
		var idVeterinario = new Veterinario(idVet);
		
		consultaRepository.findByVeterinario(idVeterinario).forEach( c -> {
			consulta.add(c);
			System.out.println("consulta"+consulta);
			
		});


		return consulta;

	}
}
