<html>

<head>

<title>Agenda de contatos - Seja bem vindo!</title>
<meta name="viewport" content="width=device-width" />

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<!-- folha de estilos CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container">
		<div class="row mt-5">
			<div class="col">
				<h2 class="text-center mb-4">Seja bem vindo a Agenda de Contatos</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Cadastro de Contatos</h5>
						<p class="card-text">Cadastre um novo contato em sua agenda.</p>
						<a href="/sistema_contatos/agenda/cadastro" class="btn btn-primary">Acessar</a>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Consulta de Contatos</h5>
						<p class="card-text">Consulte os contatos cadastrados em sua
							agenda.</p>
						<a href="/sistema_contatos/agenda/consulta" class="btn btn-primary">Acessar</a>
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