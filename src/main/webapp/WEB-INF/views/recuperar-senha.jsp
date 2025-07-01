<html>

<head>

<title>Agenda de contatos - Recuperar Senha</title>
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
						<h3>Recuperação de Senha de Acesso</h3>
					</div>
					<div class="card-body">

						<div class="text-center">Entre com seu email para recuperar sua senha:</div>
						<hr />
						
						<div class="text-center text-success">
							<h4>${mensagem_sucesso}</h4>
						</div>
						
						<div class="text-center text-danger">
							<h4>${mensagem_erro}</h4>
						</div>

						<form method="post" action="recuperar-senha-usuario">

							<div class="form-group mb-2">
								<label>Email:</label> <input type="email" class="form-control" required
									id="email" name="email" placeholder="Digite seu email">
							</div>

							<div class="d-grid mb-2">
								<button type="submit" class="btn btn-primary">
									Recuperar Senha
								</button>
							</div>
							
							<div class="d-grid mb-2">
								<a href="/sistema_contatos/" class="btn btn-light">
									Já possui conta? <strong>Acesse aqui!</strong>
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