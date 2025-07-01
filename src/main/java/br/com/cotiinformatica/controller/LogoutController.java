package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {

		// apagar os dados gravados na sessão
		request.getSession().removeAttribute("usuario_autenticado");

		// redirecionar o usuário de volta para a página de login
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}

}
