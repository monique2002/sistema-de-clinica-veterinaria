package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.arcadenoe.model.Animal;
import com.clinica.arcadenoe.model.Especie;
import com.clinica.arcadenoe.repository.AnimalRepository;
import com.clinica.arcadenoe.repository.EspecieRepository;

@Controller
@RequestMapping("funcionario/animal")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepos;
	
	@Autowired
	private EspecieRepository especieRepos;
	
	@RequestMapping("carregar")
	public String carregar(Model model) {
		
		model.addAttribute("animais", retornaAnimal());
		
		return "funcionario/animal";
	}

	
	  @RequestMapping("cadastrar")
	  public String cadastrar(Model model) {
	  
	  model.addAttribute("animal", new Animal());
	  model.addAttribute("especies", retornaEspecie());
	  
	  return "funcionario/animalCadastro";
	  
	  }
	 
	
	@RequestMapping("cadastrar/salva")
	public String salvarCadastro(Animal animal) {
		
		animalRepos.save(animal);
		
		return "redirect:/funcionario/animal/carregar";
		
	}

	
	@RequestMapping("alterar/{id}")
	public String alterar(@PathVariable int id, Model model) {
		
		var animalOptional = animalRepos.findById(id);
		
		if(animalOptional.isPresent()) {
			var animal = animalOptional.get();
			
			System.out.println(animal);
			
			model.addAttribute("animal", animal);
			model.addAttribute("especies", retornaEspecie());
			  
		}
		
		return "funcionario/animalCadastro";
	}
	
	
	
	private List<Animal> retornaAnimal() {
		
		var animal = new ArrayList<Animal>();
		
		animalRepos.findAll().forEach(a->{
			
			animal.add(a);
			
	});
		
		return animal;
	}
	
	private List<Especie> retornaEspecie() {
		
		var especie = new ArrayList<Especie>();
		
		especieRepos.findAll().forEach( e ->{
			especie.add(e);
				
		});
		
		
		return especie;
	}
	
}
