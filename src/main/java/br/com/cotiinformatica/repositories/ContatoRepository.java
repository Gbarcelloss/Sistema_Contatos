package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ContatoRepository {

	// Método para gravar os dados do contato no banco de dados
	public void save(Contato contato) throws Exception {
		
		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo comando SQL para inserir um registro na tabela de contato
		PreparedStatement statement = connection.prepareStatement
				("insert into contato(nome, email, telefone, observacoes, idusuario) values(?, ?, ?, ?, ?)");
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setString(4, contato.getObservacoes());
		statement.setInt(5, contato.getIdUsuario());
		statement.execute(); //executando..
	
		connection.close(); //fechando a conexão
	}	
	
	// Método para atualizar os dados do contato no banco de dados
	public void update(Contato contato) throws Exception {
		
		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
	
		//escrevendo comando SQL para atualizar o contato na tabela
		PreparedStatement statement = connection.prepareStatement
				("update contato set nome=?, telefone=?, email=?, observacoes=? where idcontato=?");
		
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getTelefone());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getObservacoes());
		statement.setInt(5, contato.getIdContato());
		statement.execute();
		
		connection.close();
	}
	
	// Método para excluir os dados do contato no banco de dados
	public void delete(Contato contato) throws Exception {
		
		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo comando SQL para excluir o contato na tabela
		PreparedStatement statement = connection.prepareStatement("delete from contato where idcontato = ?");
		statement.setInt(1, contato.getIdContato());
		statement.execute();
		
		connection.close();
	}	
	
	// Método para consultar os contatos no banco de dados
	public List<Contato> findAll(Integer idUsuario) throws Exception {
		
		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo comando SQL para consultar os dados da tabela de contato
		PreparedStatement statement = connection.prepareStatement("select * from contato where idusuario = ? order by nome");
		statement.setInt(1, idUsuario);
		ResultSet resultSet = statement.executeQuery();
		
		//declarando uma lista de contatos
		List<Contato> lista = new ArrayList<Contato>();
		
		//ler cada registro obtido do banco de dados
		while(resultSet.next()) {
			
			Contato contato = new Contato();
			
			contato.setIdContato(resultSet.getInt("idcontato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			contato.setObservacoes(resultSet.getString("observacoes"));
			contato.setIdUsuario(resultSet.getInt("idusuario"));
			
			lista.add(contato);
		}	
		
		connection.close();		
		return lista; //retorando a lista
	}
	
	// Método para consultar os dados de 1 contato baseado no ID
	public Contato findById(Integer idContato) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo uma consulta para retornar 1 contato através do id
		PreparedStatement statement = connection.prepareStatement("select * from contato where idcontato = ?");
		statement.setInt(1, idContato);
		ResultSet resultSet = statement.executeQuery();
		
		Contato contato = null; //vazio
		
		//verificando se algum registro foi encontrado
		if(resultSet.next()) {
			
			contato = new Contato();
			
			contato.setIdContato(resultSet.getInt("idcontato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			contato.setObservacoes(resultSet.getString("observacoes"));
			contato.setIdUsuario(resultSet.getInt("idusuario"));
		}
		
		connection.close();
		return contato;
	}
	
}









