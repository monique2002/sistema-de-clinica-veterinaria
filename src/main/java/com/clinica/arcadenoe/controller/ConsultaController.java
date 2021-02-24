package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.arcadenoe.model.Animal;
import com.clinica.arcadenoe.model.Consulta;
import com.clinica.arcadenoe.model.Veterinario;
import com.clinica.arcadenoe.repository.AnimalRepository;
import com.clinica.arcadenoe.repository.ConsultaRepository;
import com.clinica.arcadenoe.repository.VeterinarioRepository;

@Controller
@RequestMapping("/funcionario/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository consultaRepos;
	
	@Autowired
	private AnimalRepository animalRepos;
	
	@Autowired
	private VeterinarioRepository vetRepos;

	@RequestMapping("carregar")
	public String carregar(Model model) {
		
		model.addAttribute("consultas", retornaConsultas());
		
		
		return "funcionario/consulta";
	}

	@RequestMapping("cadastrar")
	public String chamaCadastro(Model model) {
		
		model.addAttribute("consulta", new Consulta());
		model.addAttribute("animais", retornaAnimal());
		model.addAttribute("veterinarios", retornaVeterinarios());
		
		
		return "funcionario/consultaCadastro";
		
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable int id, Model model) {
		
		var consultaOption = consultaRepos.findById(id);
		
		if(consultaOption.isPresent()) {
			var consulta = consultaOption.get();
			
			model.addAttribute("consulta", consulta);
			model.addAttribute("animais", retornaAnimal());
			model.addAttribute("veterinarios", retornaVeterinarios());
		}
		
		
		return "funcionario/consultaCadastro";
	}
	
	@RequestMapping("cadastrar/salvar")
	public String salva(Model model, Consulta consulta, @RequestParam (value="dataHora") String dataHora, @RequestParam (value="veterinario.crvm") Veterinario vet) {
		
		
		var consultar = consultaRepos.findByDataHoraAndVeterinario(dataHora, vet);
		
		if(consultar == null ) {
			
			consultaRepos.save(consulta);
			
		
		}else {
			System.out.println("Esse horário não esta dísponivel para o veterinario escolhido.");
			model.addAttribute("erroCadastro", "Esse horário não esta dísponivel para o veterinario escolhido.");
			model.addAttribute("consulta", new Consulta());
			model.addAttribute("animais", retornaAnimal());
			model.addAttribute("veterinarios", retornaVeterinarios());
			
			return "funcionario/consultaCadastro";
		}

		return "redirect:/funcionario/consulta/carregar";
		
		
		
	}
	
	
	private List<Consulta> retornaConsultas() {
		
		var consulta = new ArrayList<Consulta>();
	
		consultaRepos.findAll().forEach(c->{
			consulta.add(c);
			
		});
		
		return consulta;
	}
	
	
	private List<Veterinario> retornaVeterinarios() {

		var veterinario = new ArrayList<Veterinario>();

		vetRepos.findAll().forEach( v -> {

			veterinario.add(v);

		});


		return veterinario;
	}
	
	
	private List<Animal> retornaAnimal() {
		
		var animal = new ArrayList<Animal>();
		
		animalRepos.findAll().forEach(a->{
			
			animal.add(a);
			
	});
		
		return animal;
	}
	

}
