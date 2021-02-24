package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clinica.arcadenoe.model.Especie;
import com.clinica.arcadenoe.repository.EspecieRepository;


@Controller
@RequestMapping("funcionario/especie")
public class EspecieController {

	@Autowired
	private EspecieRepository especieRepos;
	
	@RequestMapping("carrega")
	public String carregaEspecie(Model model) {
		
		model.addAttribute("returnEspecies", retornaEspecies());
		
		return "funcionario/especie";
		
	}
	
	@RequestMapping("cadastrar")
	public String cadastra(Model model) {
		
		model.addAttribute("especie", new Especie());
		
		return "funcionario/especieCadastro";
	}
	
	@RequestMapping("cadastrar/salva")
	public String salva(Especie especie) {
	
		especieRepos.save(especie);

		return "redirect:/funcionario/especie/carrega";
	}
	
	@RequestMapping("alterar/{id}")
	public String altera(@PathVariable int id, Model model) {
	
		var especieOptional = especieRepos.findById(id);

		
		if(especieOptional.isPresent()) {
			
			var especie = especieOptional.get();
			
			model.addAttribute("especie", especie);
		}
		
		return "funcionario/especieCadastro";
	}
	
	
	private List<Especie> retornaEspecies(){

		var especies = new ArrayList<Especie>();

		especieRepos.findAll().forEach( e -> {
			especies.add(e);
			});
		

		return especies;
		
	}
}
