package com.clinica.arcadenoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("funcionario")
public class HomeControllerFunc {

	@RequestMapping("")
	public String carregaHomeFunc() {
		
		return "funcionario/homeFunc";
	}
}
