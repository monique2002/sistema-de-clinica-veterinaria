package com.clinica.arcadenoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.clinica.arcadenoe.repository.FuncionarioRepository;
import com.clinica.arcadenoe.repository.VeterinarioRepository;

@Controller
@RequestMapping("indexLogin")
public class IndexLoginController {
	
	@Autowired
	private FuncionarioRepository funcRepos;
	
	@Autowired
	private VeterinarioRepository vetRepos;
	
	Integer tipoUsuario;
	
	@RequestMapping("/{id}")
	public String carregaIndex(@PathVariable int id) {
		tipoUsuario = id;
		return "indexLogin";

	}

	@RequestMapping("/logar")
	public String carregaPagina(@RequestParam (value="email")String email, @RequestParam(value = "senha")String senha,
			Model model) {


		if(tipoUsuario == 1) {
			
			var vet = vetRepos.findByEmailAndSenha(email, senha);
		
			if( vet != null) {
				int id = vet.getCrvm();
	
				return "redirect:/veterinario/tratamento/salvaId/"+id;

			}else {
				model.addAttribute("erroLogin", "Login Errado: favor tente novamente.");
			}
		}else if(tipoUsuario == 2) {

			if(funcRepos.findByEmailAndSenha(email, senha) != null) {

				return "funcionario/homeFunc";

			}else {

				model.addAttribute("erroLogin", "Login Errado: favor tente novamente.");
			}

		}else {
			model.addAttribute("erroLogin", "Login Errado: favor tente novamente.");
		}

		
		return "indexLogin";

	}
	
}
