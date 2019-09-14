package br.com.system.pigCinco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 Projeto de autoria do PIG5 - Grupo5 
 */

@Controller
@RequestMapping("")
public class ClienteController {

	@GetMapping("/funcionarioCrm")
	public ModelAndView funcionarios () {
		ModelAndView mv = new ModelAndView("funcionario/paginaFuncionarios");
		return mv;
	}
}
