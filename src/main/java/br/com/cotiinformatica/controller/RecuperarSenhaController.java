package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.javafaker.Faker;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.EmailMessage;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RecuperarSenhaController {

	@RequestMapping(value = "/recuperar-senha") // rota de navegação
	public ModelAndView recuperarSenha() {

		// WEB-INF/views/recuperar-senha.jsp
		ModelAndView modelAndView = new ModelAndView("recuperar-senha");
		return modelAndView;
	}
	
	@RequestMapping(value = "/recuperar-senha-usuario", method = RequestMethod.POST)
	public ModelAndView recuperarSenhaUsuario(HttpServletRequest request) {
	
		ModelAndView modelAndView = new ModelAndView("recuperar-senha");
		
		try {
			
			String email = request.getParameter("email");
			
			//buscar no banco de dados o usuário que possua este email cadastrado
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmail(email);
			
			//verificar se o usuário foi encontrado
			if(usuario != null) {
				
				//gerando uma nova senha para o usuário
				Faker faker = new Faker();
				String novaSenha = "@1" + faker.internet().password(8, 10, true, true);

				String to = usuario.getEmail();
				String subject = "Recuperação de senha de acesso - Sistema Contatos";
				String body = "\nOlá " + usuario.getNome()
						    + "\nUma nova senha foi gerada com sucesso."
						    + "\nAcesse o sistema com a senha: " + novaSenha
						    + "\nE em seguida, use o menu 'Minha Conta' para alterar a senha."
						    + "\n\nAtt,"
						    + "\nEquipe Sistema Contas";
				
				//enviando o email para o usuário
				EmailMessage.sendMessage(to, subject, body);
				
				//atualizando a senha do usuário no banco de dados
				usuarioRepository.update(usuario.getIdUsuario(), novaSenha);
				
				modelAndView.addObject("mensagem_sucesso", "Recuperação de senha realizada com sucesso. Verifique sua conta de email.");
			}
			else {
				modelAndView.addObject("mensagem_erro", "Usuário não encontrado.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao recuperar senha: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
