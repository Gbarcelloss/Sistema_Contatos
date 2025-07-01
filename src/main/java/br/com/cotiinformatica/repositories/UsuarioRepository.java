package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {

	// Método para gravar os dados do usuário no banco de dados
	public void save(Usuario usuario) throws Exception {

		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//Escrevendo um comando SQL para execução no banco de dados
		PreparedStatement statement = connection.prepareStatement("insert into usuario(nome, email, senha) values(?, ?, md5(?))");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();
		
		//Fechando a conexão com o banco de dados
		connection.close();
	}
	
	// Método para atualizar os dados do usuário no banco de dados
	public void update(Integer idUsuario, String novaSenha) throws Exception {
		
		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//Escrevendo um comando SQL para execução no banco de dados
		PreparedStatement statement = connection.prepareStatement("update usuario set senha=md5(?) where idusuario=?");
		statement.setString(1, novaSenha);
		statement.setInt(2, idUsuario);
		statement.execute();
		
		//Fechando a conexão com o banco de dados
		connection.close();
	}
	
	
	// Método para consultar 1 usuário através do email
	public Usuario findByEmail(String email) throws Exception {
		
		//Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//Escrevendo um comando SQL para execução no banco de dados
		PreparedStatement statement = connection.prepareStatement("select * from usuario where email=?");
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		
		Usuario usuario = null;
		
		//verificando se algum registro foi encontrado
		if(resultSet.next()) {
			
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}
		
		connection.close(); //fechando a conexão
		return usuario;
	}
	
	// Método para consultar 1 usuário através do email e da senha
	public Usuario findByEmailAndSenha(String email, String senha) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//executando o comando SQL para fazer a consulta
		PreparedStatement statement = connection.prepareStatement("select * from usuario where email=? and senha=md5(?)");
		statement.setString(1, email);
		statement.setString(2, senha);
		ResultSet resultSet = statement.executeQuery();
		
		Usuario usuario = null;
		
		//verificando se algum registro foi encontrado
		if(resultSet.next()) {
			
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}
		
		connection.close(); //fechando a conexão
		return usuario;
	}
	

}





