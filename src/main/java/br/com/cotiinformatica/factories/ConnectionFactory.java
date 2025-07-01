package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// atributos
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String HOST = "jdbc:postgresql://localhost:5432/bd_sistema_contatos";
	private static final String USER = "postgres";
	private static final String PASS = "coti";

	// método para abrir e retornar uma conexão com o banco de dados
	public static Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(HOST, USER, PASS);
	}
}
