package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clinica.arcadenoe.model.Especie;
import com.clinica.arcadenoe.model.Veterinario;
import com.clinica.arcadenoe.repository.EspecieRepository;
import com.clinica.arcadenoe.repository.VeterinarioRepository;

@Controller
@RequestMapping("funcionario/veterinario/")
public class VeterinarioController {

	@Autowired
	private VeterinarioRepository veterinarioRepos;
	
	@Autowired
	private EspecieRepository especieRepos;
	
	@RequestMapping("carregar")
	public String carrega(Model model) {
		
		model.addAttribute("veterinarios", retornarVeterinarios());
	
		
		return "/funcionario/veterinario";
		
	}

	@RequestMapping("/cadastrar")
	public String carregar(Model model) {
		
		model.addAttribute("listaEspecie", retornaEspecie());
		model.addAttribute("veterinario", new Veterinario());
		
		return "/funcionario/veterinarioCadastro";
	}
	
	@RequestMapping("cadastrar/salva")
	public String salvar(Veterinario veterinario) {
		
		veterinarioRepos.save(veterinario);
		
		return "redirect:/funcionario/veterinario/carregar";
		
	}
	
	
	@RequestMapping("alterar/{crvm}")
	public String alterar(@PathVariable int crvm, Model model) {
		
		var veterinarioOptional = veterinarioRepos.findById(crvm);
		
		if(veterinarioOptional.isPresent()) {
			
			var veterinario  = veterinarioOptional.get();
			
			model.addAttribute("veterinario", veterinario);
			model.addAttribute("desabilita", veterinario);
		}
		
		
	
		return "/funcionario/veterinarioCadastro";
		
	}
	
	private List<Especie> retornaEspecie() {
		
		List<Especie> especie = new ArrayList<Especie>();
		
		especieRepos.findAll().forEach(e -> {
			especie.add(e);
		});
		
		
		return especie;
	}

	private List<Veterinario> retornarVeterinarios() {
		
		var veterinario = new ArrayList<Veterinario>();
		
		veterinarioRepos.findAll().forEach( v -> {
			
			veterinario.add(v);
			
		});
		
		
		return veterinario;
	}
}
