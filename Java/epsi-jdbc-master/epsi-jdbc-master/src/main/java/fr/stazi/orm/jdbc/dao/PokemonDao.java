package fr.stazi.orm.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.stazi.orm.jdbc.mapping.PokemonMapper;
import fr.stazi.orm.jdbc.model.Pokemon;
import fr.stazi.orm.jdbc.model.Type;

public class PokemonDao extends GenericDao {
	
	private PokemonMapper mapper;
	private TypeDao typeDao; 
	
	public PokemonDao(Connection connection) {
		super(connection);
		mapper = new PokemonMapper();
		typeDao = new TypeDao(connection); 
	}

	/**
	 * Insers a pokemon.
	 * @throws SQLException 
	 */
	public void insert(Pokemon pokemon) throws SQLException {		
		String sql = "INSERT INTO pokemon (number_, name_, health_points, evolution) VALUES\n" + 
				"("+pokemon.getNumber()+", "+pokemon.getName()+", "+pokemon.getHealthPoints()+", "+pokemon.getEvolution().getId()+"), "; // Ecrire la requête ici
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}

	/**
	 * Finds all pokemons.
	 * @return A list containing all the pokemons.
	 * @throws SQLException 
	 */
	public List<Pokemon> findAll() throws SQLException {
		List<Pokemon> allPokemons = new ArrayList<Pokemon>();
		
		String sql = "SELECT id, number_, name_, health_points FROM pokemon ORDER BY number_";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Pokemon pokemon = mapper.process(rs); // Complèter le mapper
			
			
			//Récupération des types 
			List<Type> types = typeDao.findByPokemonId(pokemon.getId());
			pokemon.setTypes(types);
			
			allPokemons.add(pokemon);
		}
		
		
		return allPokemons;
	}

	/**
	 * Finds a pokemon by its id.
	 * @return The matching pokemon, otherwise null.
	 * @throws SQLException 
	 */
	public Pokemon findById(long id) throws SQLException {
		Pokemon pokemon = null;
		
		String sql = "SELECT id, number_, name_, health_points FROM pokemon WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();
		
		// Faire le mapping ici
		while(rs.next()) {
			pokemon = mapper.process(rs); // Complèter le mapper
			
		}
		
		return pokemon;
	}

	/**
	 * Finds a pokemon by its number.
	 * @return The matching pokemon, otherwise null.
	 * @throws SQLException 
	 */
	public Pokemon findByNumber(int number) throws SQLException {
		Pokemon pokemon = null;
		
		String sql = "SELECT id, number_, name_, health_points FROM pokemon WHERE number_ = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, number);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			pokemon = mapper.process(rs); // Complèter le mapper
			
		}
		
		
		return pokemon;
	}
	
	/**
	 * Finds pokemons belonging to a trainer.
	 * @return The list of matching pokemons.
	 * @throws SQLException
	 */
	public List<Pokemon> findByTrainerId(long trainerId) throws SQLException {
		List<Pokemon> pokemons = null;
		
		String sql = "SELECT pokemon.*" + 
				"FROM pokemon , pokemon_dresse , dresseur\n" + 
				"WHERE dresseur_id = ? " + 
				"and dresseur.id = pokemon_dresse.dresseur_id " + 
				"and pokemon_dresse.pokemon_id = pokemon.id "; // Ecrire la requête SQL ici
		PreparedStatement statement = connection.prepareStatement(sql);
		// Ajouter le paramètre de la requete
		statement.setLong(1, trainerId);
		
		ResultSet rs = statement.executeQuery();
		
		// Faire le mapping ici
		while(rs.next()) {
			Pokemon pokemon = mapper.process(rs); // Complèter le mapper
			pokemons.add(pokemon);
		}
		
		return pokemons;
	}
}
