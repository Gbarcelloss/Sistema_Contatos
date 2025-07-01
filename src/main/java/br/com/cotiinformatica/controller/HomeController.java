package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/agenda/home") // rota de navegação
	public ModelAndView home() {

		// WEB-INF/views/agenda/home.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/home");
		return modelAndView;
	}
}
