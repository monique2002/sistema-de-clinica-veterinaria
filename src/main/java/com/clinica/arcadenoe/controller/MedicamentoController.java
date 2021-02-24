package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clinica.arcadenoe.model.Medicamento;
import com.clinica.arcadenoe.repository.MedicamentoRepository;

@Controller
@RequestMapping("funcionario/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoRepository medicamentoRepos;
	
	@RequestMapping("carrega")
	public String carregaMedicamento(Model model) {
		
		model.addAttribute("medicamentos", retornaMedicamento());
		model.addAttribute("medicamento", new Medicamento());
		
		return "funcionario/medicamento";
		
	}
	
	@RequestMapping("cadastrar")
	public String chamaCadastro(@ModelAttribute Medicamento medicamento) {
		
		return "funcionario/medicamentoCadastro";
	}
	
	@RequestMapping("/cadastrar/salva")
	public String salvaCadastro(@ModelAttribute Medicamento medicamento) {
		
		System.out.println(medicamento);
		
		medicamentoRepos.save(medicamento);
		
		return "redirect:/funcionario/medicamento/carrega";
		
		
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable int id, Medicamento medicamento) {
		
		medicamentoRepos.delete(medicamento);
		
		return "redirect:/funcionario/medicamento/carrega";
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable int id, Model model) {
		
		var medicamentoOption = medicamentoRepos.findById(id);
		
		if(medicamentoOption.isPresent()) {
			var medicamento = medicamentoOption.get();
			
			model.addAttribute("medicamento", medicamento);
		}
		
		
		return "funcionario/medicamentoCadastro";
		
	}
	
	
	
	private List<Medicamento> retornaMedicamento(){

		var medicamentos = new ArrayList<Medicamento>();

		medicamentoRepos.findAll().forEach( m -> {
			medicamentos.add(m);
			
		});


		return medicamentos;

	}
}
