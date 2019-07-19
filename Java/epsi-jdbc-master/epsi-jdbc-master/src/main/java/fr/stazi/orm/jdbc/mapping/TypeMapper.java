package fr.stazi.orm.jdbc.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.stazi.orm.jdbc.model.Dresseur;
import fr.stazi.orm.jdbc.model.Pokemon;
import fr.stazi.orm.jdbc.model.Type;

public class TypeMapper {
	
	public Type process(ResultSet rs) throws SQLException {
		Type t = new Type();
		
		// Exemple d'utilisation : rs.getInt(0)
		// Essaie de récupérer la première colonne du tuple en cours sous forme d'entier

		long id = rs.getLong(1);
		t.setId(id);
		
		t.setLabel(rs.getString(2));
			
		System.out.println(" >" +t);
		
		return t;
	}
	
	
	
	
	
}
