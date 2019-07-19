package fr.stazi.orm.jdbc.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.stazi.orm.jdbc.model.Pokemon;

public class PokemonMapper {
	
	public Pokemon process(ResultSet rs) throws SQLException {
		Pokemon pokemon = new Pokemon();
		
		// Exemple d'utilisation : rs.getInt(0)
		// Essaie de récupérer la première colonne du tuple en cours sous forme d'entier
		//SELECT id, number_, name_, health_points FROM pokemon ORDER BY number_
		long id = rs.getLong(1);
		pokemon.setId(id);
		
		int number = rs.getInt(2);
		pokemon.setNumber(number);
		
		String name = rs.getString(3);
		pokemon.setName(name);
		
		int hp = rs.getInt(4);
		pokemon.setHealthPoints(hp);
			
		System.out.println("DAns le mapper >" +pokemon);
		
		return pokemon;
	}
	
	
	
	
	
}
