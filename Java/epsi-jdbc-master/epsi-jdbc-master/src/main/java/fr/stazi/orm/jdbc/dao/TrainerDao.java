package fr.stazi.orm.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.stazi.orm.jdbc.model.Dresseur;
import fr.stazi.orm.jdbc.model.Pokemon;

public class TrainerDao extends GenericDao {
	
	public TrainerDao(Connection connection) {
		super(connection);
	}

	/**
	 * Finds all trainers.
	 * @return A list containing all the trainers.
	 * @throws SQLException 
	 */
	public List<Dresseur> findAll() throws SQLException {
		List<Dresseur> allDresseurs = null;
		
		// TODO: A compléter
		
		return allDresseurs;
	}

	/**
	 * Finds a pokemon by its id.
	 * @return The matching pokemon, otherwise null.
	 * @throws SQLException 
	 */
	public Pokemon findById(int number) throws SQLException {
		Pokemon pokemon = null;
		
		String sql = "SELECT number_, name_, health_points FROM pokemon WHERE number_ = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(0, number);
		ResultSet rs = statement.executeQuery();
		
		// Faire le mapping ici
		
		return pokemon;
	}
	
	/**
	 * Finds pokemons belonging to a trainer.
	 * @return The list of matching pokemons.
	 * @throws SQLException
	 */
	public List<Pokemon> findByTrainerId(long trainerId) throws SQLException {
		List<Pokemon> pokemons = null;
		
		String sql = ""; // Ecrire la requête SQL ici
		PreparedStatement statement = connection.prepareStatement(sql);
		// Ajouter le paramètre de la requete
		ResultSet rs = statement.executeQuery();
		
		// Faire le mapping ici
		
		return pokemons;
	}
}
