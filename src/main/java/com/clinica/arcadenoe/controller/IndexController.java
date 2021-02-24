package com.clinica.arcadenoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.arcadenoe.model.TipoUsuario;
import com.clinica.arcadenoe.repository.TipoUsuarioRepository;


@Controller
public class IndexController{
	
	@Autowired
	private TipoUsuarioRepository tipoUserRepos;
	
	
	@RequestMapping("index")
	public String carregaHome(Model model) {
		
		model.addAttribute("tipoUsuario", retornaTipoUsuario());
		
		return "index";
		
	}

	@RequestMapping("/index/login")
	public String carregaLogin(@RequestParam (value="tipoUsuario")String tipo, Model model) {
		
		model.addAttribute("tipoUsuario", tipo);
	
	
		return "redirect:/indexLogin/"+tipo;	
	}
	
	
	
	private List<TipoUsuario> retornaTipoUsuario(){
		var tipoUsuario = new ArrayList<TipoUsuario>();
	
		tipoUserRepos.findAll().forEach( t ->{
			tipoUsuario.add(t);

		});
		
		return tipoUsuario;
	}
	

	
	
}