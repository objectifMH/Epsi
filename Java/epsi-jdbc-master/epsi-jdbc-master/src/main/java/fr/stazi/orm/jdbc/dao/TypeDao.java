package fr.stazi.orm.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.stazi.orm.jdbc.mapping.PokemonMapper;
import fr.stazi.orm.jdbc.mapping.TypeMapper;
import fr.stazi.orm.jdbc.model.Pokemon;
import fr.stazi.orm.jdbc.model.Type;

public class TypeDao extends GenericDao {
	
	private TypeMapper mapper;
	
	public TypeDao(Connection connection) {
		super(connection);
		mapper = new TypeMapper();
	}

	/**
	 * Insers a pokemon.
	 * @throws SQLException 
	 */
	public void insert(Pokemon pokemon) throws SQLException {		
		String sql = ""; // Ecrire la requête ici
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}

	

	/**
	 * Finds a pokemon by its id.
	 * @return The matching pokemon, otherwise null.
	 * @throws SQLException 
	 */
	public Pokemon findByNumber(long id) throws SQLException {
		Pokemon pokemon = null;
		
		String sql = "SELECT id, number_, name_, health_points FROM pokemon WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(0, id);
		ResultSet rs = statement.executeQuery();
		
		// Faire le mapping ici
		
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
	public List<Type> findByPokemonId(long pokemonId) throws SQLException {
		List<Type> types = new ArrayList<>();
		
		String sql = "SELECT id , label FROM pokemon_est_de_type pedt JOIN type_pokemon tp on pedt.type_id = tp.id where pedt.pokemon_id = ?"; // Ecrire la requête SQL ici
		PreparedStatement statement = connection.prepareStatement(sql);
		// Ajouter le paramètre de la requete
		statement.setLong(1, pokemonId);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Type ty = mapper.process(rs); // Complèter le mapper
			types.add(ty);
		}
		
		return types;
	}
}
