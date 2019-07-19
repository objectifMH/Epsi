package fr.stazi.orm.jdbc.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.stazi.orm.jdbc.model.Dresseur;
import fr.stazi.orm.jdbc.model.Pokemon;

public class DresseurMapper {
	
	public Dresseur process(ResultSet rs) throws SQLException {
		Dresseur dres = new Dresseur();
		
		// Exemple d'utilisation : rs.getInt(0)
		// Essaie de récupérer la première colonne du tuple en cours sous forme d'entier

		long id = rs.getLong(1);
		dres.setId(id);
		
		String nom = rs.getString(2);
		dres.setNom(nom);
		
		String ville = rs.getString(3);
		dres.setVille(ville);
		
			
		System.out.println(" >" +dres);
		
		return dres;
	}
	
	
	
	
	
}
