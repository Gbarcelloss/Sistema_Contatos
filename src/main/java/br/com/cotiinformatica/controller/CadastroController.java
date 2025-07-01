package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class CadastroController {

	@RequestMapping(value = "/agenda/cadastro")
	public ModelAndView cadastro() {
		// WEB-INF/views/agenda/cadastro.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/cadastro");
		return modelAndView;
	}
	
	@RequestMapping(value = "/agenda/cadastrar-contato", method = RequestMethod.POST)
	public ModelAndView cadastrarContato(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("agenda/cadastro");
		
		try {
			
			Contato contato = new Contato();
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			contato.setNome(request.getParameter("nome_contato"));
			contato.setEmail(request.getParameter("email_contato"));
			contato.setTelefone(request.getParameter("telefone_contato"));
			contato.setObservacoes(request.getParameter("observacoes_contato"));
			contato.setIdUsuario(usuario.getIdUsuario());
			
			ContatoRepository contatoRepository = new ContatoRepository();
			contatoRepository.save(contato);
			
			modelAndView.addObject("mensagem_sucesso", "Contato " + contato.getNome() + ", cadastrado com sucesso!");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao cadastrar contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
}
