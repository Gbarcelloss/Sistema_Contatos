package br.com.cotiinformatica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class ConsultaController {

	@RequestMapping(value = "/agenda/consulta")
	public ModelAndView consulta(HttpServletRequest request) {
		
		// WEB-INF/views/agenda/consulta.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/consulta");
		
		try {
			
			//capturando o usuário armazenado em sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			//consultando os contatos do usuário
			ContatoRepository contatoRepository = new ContatoRepository();
			List<Contato> lista = contatoRepository.findAll(usuario.getIdUsuario());
			
			//enviando a lista para a página
			modelAndView.addObject("lista_contatos", lista);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao consultar contatos: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
