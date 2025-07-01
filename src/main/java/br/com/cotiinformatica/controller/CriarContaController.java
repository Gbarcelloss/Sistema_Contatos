package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class CriarContaController {

	@RequestMapping(value = "/criar-conta") // rota de navegação
	public ModelAndView criarConta() {

		// WEB-INF/views/criar-conta.jsp
		ModelAndView modelAndView = new ModelAndView("criar-conta");
		return modelAndView;
	}
	
	/*
	 * Método para receber o SUBMIT do formulário, capturar os campos
	 * enviados e então gravar no banco de dados.
	 */
	@RequestMapping(value = "/cadastrar-usuario", method = RequestMethod.POST) 
	public ModelAndView cadastrarUsuario(HttpServletRequest request) {

		// WEB-INF/views/criar-conta.jsp
		ModelAndView modelAndView = new ModelAndView("criar-conta");
		
		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(request.getParameter("nome_usuario"));
			usuario.setEmail(request.getParameter("email_usuario"));
			usuario.setSenha(request.getParameter("senha_usuario"));
			
			//gravando o usuário no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			
			//verificar se já existe um usuário cadastrado com o email informado
			if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				//retornar resposta para a página
				modelAndView.addObject("mensagem_erro", "O email '" + usuario.getEmail() + "' já está cadastrado. Tente outro.");
			}
			else {
				//cadastrando o usuário no banco de dados
				usuarioRepository.save(usuario);
				
				//retornar resposta para a página
				modelAndView.addObject("mensagem_sucesso", "Parabéns " + usuario.getNome() + ", sua conta de usuário foi criada com sucesso!");
			}
		}
		catch(Exception e) {
			//retornar resposta para a página
			modelAndView.addObject("mensagem_erro", "Falha: " + e.getMessage());
		}
		
		return modelAndView;
	}		
}
