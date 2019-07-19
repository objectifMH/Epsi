package fr.stazi.orm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.stazi.orm.jdbc.dao.PokemonDao;

public class App {

	private static final String JDBC_CONNECTION_STRING = "jdbc:postgresql://%s:%s/%s";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Chargement du driver de connexion à Postgresql
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to find JDBC driver.");
			throw e;
		}
		
		String hostname = "localhost";
		String port = "5432";
		String dbName = "pokemon";
		String username = "postgres";
		String password = "root";
		String connectionString = String.format(JDBC_CONNECTION_STRING, hostname, port, dbName);
		System.out.println(connectionString);
		
		// Connexion à la base de données		
		try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
			PokemonDao pokemonDao = new PokemonDao(connection);
			
			pokemonDao.findAll().forEach(p -> System.out.println(p));
			/* 
			 * pokemonDao.findByNumber(1);
			 
			pokemonDao.findByNumber(2);
			pokemonDao.findById(5);
			pokemonDao.findByTrainerId(3);
			*/
			
			
		}
	}

}
