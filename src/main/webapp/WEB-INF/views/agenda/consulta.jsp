<%@ page import="java.util.List" %>
<%@ page import="br.com.cotiinformatica.entities.Contato" %>

<%
	//capturando a lista de contatos enviada pelo controlador
	List<Contato> lista = (List<Contato>) request.getAttribute("lista_contatos");
%>

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

	<div class="card m-4">
	<div class="card-body">

		<h5>Consulta de contatos</h5>
		<p>Listagem de contatos cadastrados na sua agenda.</p>
		<hr />
		
		<div class="text-success">
			<h4>${mensagem_sucesso}</h4>
		</div>
						
		<div class="text-danger">
			<h4>${mensagem_erro}</h4>
		</div>

		<div class="table-responsive">
				
			<table class="table table-sm table-hover">
				<thead>
					<tr>
						<th>Nome do contato</th>
						<th>Email</th>
						<th>Telefone</th>
						<th>Observações</th>
						<th>Operações</th>
					</tr>
				</thead>
				<tbody>
				
					<% for(Contato contato : lista) { %>
				
					<tr>
						<td><%= contato.getNome() %></td>
						<td><%= contato.getEmail() %></td>
						<td><%= contato.getTelefone() %></td>
						<td><%= contato.getObservacoes() %></td>
						<td>
							<a href="/sistema_contatos/agenda/edicao?idContato=<%= contato.getIdContato() %>" 
								class="btn btn-sm btn-primary">
								Editar
							</a>
							<a href="/sistema_contatos/agenda/exclusao?idContato=<%= contato.getIdContato() %>" 
								onclick="return confirm('Deseja realmente excluir o contato selecionado?');"
								class="btn btn-sm btn-danger">
								Excluir
							</a>
						</td>
					</tr>
					
					<% } %>
					
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							Quantidade de contatos em sua agenda: <%= lista.size() %>
						</td>
					</tr>
				</tfoot>
			</table>
		
		</div>

	</div>
	</div>

	<!-- arquivos JS do bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>