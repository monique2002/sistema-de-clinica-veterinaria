package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clinica.arcadenoe.model.Exame;
import com.clinica.arcadenoe.repository.ExameRepository;

@Controller
@RequestMapping("funcionario/exame")
public class ExameController {

	@Autowired
	private ExameRepository exameRepos;
	
	@RequestMapping("carrega")
	public String carregaExame(Model model) {
		
		model.addAttribute("exames", retornaExames());
		
		return "funcionario/exame";
		
	}
	
	@RequestMapping("cadastrar")
	private String cadastroChamar(Model model){
		
		model.addAttribute("exame", new Exame());
		
		return "funcionario/exameCadastro";
		
	}
	
	@RequestMapping("/cadastrar/salva")
	private String cadastro(@ModelAttribute Exame exame){
		
		System.out.println(exame);
		
		exameRepos.save(exame);
		
		return "redirect:/funcionario/exame/carrega";
		
	}
	
	@RequestMapping("/deleta/{id}")
	public String deletar(@PathVariable int id) {
		
		exameRepos.deleteById(id);
		
		return "redirect:/funcionario/exame/carrega";
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable int id, Model  model) {
		
		var exameOption = exameRepos.findById(id);
		
		if(exameOption.isPresent()) {
			var exame = exameOption.get();

			model.addAttribute("exame", exame);
			
		}
		
		
		return "funcionario/exameCadastro";
		
		
	}
	
	
	
	private List<Exame> retornaExames(){

		var exames = new ArrayList<Exame>();

		exameRepos.findAll().forEach( e -> {
			exames.add(e);
			
		});


		return exames;

	}
}
