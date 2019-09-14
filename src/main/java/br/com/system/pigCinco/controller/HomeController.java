package br.com.system.pigCinco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
Projeto de autoria do PIG5 - Grupo5 
*/


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/dashboard";
	}

}
