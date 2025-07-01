package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class MinhaContaController {

	@RequestMapping(value = "/agenda/minhaconta")
	public ModelAndView minhaConta() {
		// WEB-INF/views/agenda/minhaconta.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/minhaconta");
		return modelAndView;
	}
	
	@RequestMapping(value = "/agenda/alterar-senha", method = RequestMethod.POST)
	public ModelAndView alterarSenha(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("agenda/minhaconta");
		
		try {
			
			//capturar o usuário autenticado no sistema
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			//capturar os campos enviados pelo formulário
			String senhaAtual = request.getParameter("senhaAtual");
			String novaSenha = request.getParameter("novaSenha");
			
			//verificar se a senha atual do usuário está correta
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			if(usuarioRepository.findByEmailAndSenha(usuario.getEmail(), senhaAtual) != null) {
				//atualizando a senha do usuário
				usuarioRepository.update(usuario.getIdUsuario(), novaSenha);
				modelAndView.addObject("mensagem_sucesso", "Senha de acesso alterada com sucesso.");
			}
			else {
				modelAndView.addObject("mensagem_erro", "Senha atual inválida.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao alterar senha: " + e.getMessage());
		}
		
		return modelAndView;
	}

}
