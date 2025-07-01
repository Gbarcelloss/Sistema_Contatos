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
public class EdicaoController {

	@RequestMapping(value = "/agenda/edicao")
	public ModelAndView edicao(HttpServletRequest request) {
		
		// WEB-INF/views/agenda/edicao.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/edicao");
		
		try {			
			//capturar o usuário autenticado na sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			//capturar o id do contato enviado na URL (query string)
			Integer idContato = Integer.parseInt(request.getParameter("idContato"));
			
			//capturar os dados do contato no banco de dados
			ContatoRepository contatoRepository = new ContatoRepository();
			Contato contato = contatoRepository.findById(idContato);
			
			//perciso verificar se o contato foi encontrado e se é um contato
			//pertencente ao usuário que está autenticado
			if(contato != null && contato.getIdUsuario() == usuario.getIdUsuario()) {
				//enviando os dados do contato para a página
				modelAndView.addObject("contato", contato);
			}
			else {
				modelAndView.setViewName("redirect:/agenda/consulta");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao obter contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/agenda/editar-contato", method = RequestMethod.POST)
	public ModelAndView editarContato(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("agenda/edicao");
		
		try {
			
			//capturar os campos enviados pelo formulário
			Contato contato = new Contato();
			
			contato.setIdContato(Integer.parseInt(request.getParameter("idContato")));
			contato.setNome(request.getParameter("nome_contato"));
			contato.setEmail(request.getParameter("email_contato"));
			contato.setTelefone(request.getParameter("telefone_contato"));
			contato.setObservacoes(request.getParameter("observacoes_contato"));
			
			//atualizando o contato no banco de dados
			ContatoRepository contatoRepository = new ContatoRepository();
			contatoRepository.update(contato);
			
			modelAndView.addObject("mensagem_sucesso", "Contato atualizado com sucesso.");
			modelAndView.addObject("contato", contato);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao atualizar o contato: " + e.getMessage());
		}
		
		return modelAndView;
	}

}











