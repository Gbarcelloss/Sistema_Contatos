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
public class ExclusaoController {

	@RequestMapping(value = "/agenda/exclusao")
	public ModelAndView exclusao(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("agenda/consulta");
		
		try {
			
			//capturando os dados do usuário autenticado na sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			//capturando o id do contato enviado pelo link (URL)
			Integer idContato = Integer.parseInt(request.getParameter("idContato"));
			
			//buscar o contato no banco de dados
			ContatoRepository contatoRepository = new ContatoRepository();
			Contato contato = contatoRepository.findById(idContato);
			
			//verificar se o contato foi encontrado e se ele pertence ao usuário autenticado
			if(contato != null && contato.getIdUsuario() == usuario.getIdUsuario()) {
				
				//excluindo o contato
				contatoRepository.delete(contato);
				modelAndView.addObject("mensagem_sucesso", "Contato excluído com sucesso.");
			}
			
			//fazer uma nova consulta no banco de dados
			List<Contato> lista = contatoRepository.findAll(usuario.getIdUsuario());
			modelAndView.addObject("lista_contatos", lista);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao excluir contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
}
