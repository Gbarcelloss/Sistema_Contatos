<html>

<head>

<title>Agenda de contatos - Acessar conta</title>
<meta name="viewport" content="width=device-width" />

<!-- folha de estilos CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header text-center">
						<h3>Autenticação de Usuários</h3>
					</div>
					<div class="card-body">

						<div class="text-center">Entre com suas credenciais de
							acesso:</div>
						<hr />
						
						<div class="text-center text-danger">
							<h4>${mensagem_erro}</h4>
						</div>

						<form method="post" action="autenticar-usuario">

							<div class="form-group mb-2">
								<label>Email:</label> 
								<input type="email" class="form-control"
									name="email_usuario"
									required="required"
									id="email" placeholder="Digite seu email">
							</div>

							<div class="form-group mb-2">
								<label>Senha:</label> 
									<input type="password" 
									name="senha_usuario"
									required="required"
									pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}" 
       								title="A senha deve ter pelo menos 8 caracteres, incluindo pelo menos uma letra minúscula, uma letra maiúscula, um número e um caractere especial (!@#$%^&*)."
									class="form-control" id="senha" placeholder="Digite sua senha">
							</div>
							
							<div class="mb-2 text-end">
								<a href="/sistema_contatos/recuperar-senha">
									Esqueci minha senha?
								</a>
							</div>

							<div class="d-grid mb-2">
								<button type="submit" class="btn btn-primary">
									Entrar
								</button>
							</div>
							
							<div class="d-grid mb-2">
								<a href="/sistema_contatos/criar-conta" class="btn btn-light">
									Não possui conta? <strong>Cadastre-se aqui!</strong>
								</a>
							</div>
							
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- arquivos JS do bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>