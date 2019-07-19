	package fr.epsi.stazi.jpahibernate.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.epsi.stazi.jpahibernate.model.*;

public class TypeDao extends GenericDao {

	/**
	 * Inserts a type.
	 * @throws SQLException 
	 */
	public void insert(Type ty) throws SQLException {
		EntityManager entityManager = getEntityManager();
		
		entityManager.persist(ty);
		//entityManager
		
		// TODO:
		
		
	}

	/**
	 * Finds all Type.
	 * @return A list containing all the Types.
	 * @throws SQLException 
	 */
	public List<Type> findAll() throws SQLException {
		
		
		EntityManager entityManager = getEntityManager();
		TypedQuery<Type> query = entityManager.createQuery("from Type_pokemon", Type.class);
		List<Type> allTypes = query.getResultList();
		
		
		
		return allTypes;
	}

	/**
	 * Finds a Type by its id.
	 * @return The matching Type, otherwise null.
	 * @throws SQLException 
	 */
	public Type findById(long id) throws SQLException {
		Type ty = null;
		
		// TODO:
		EntityManager entM = getEntityManager();
		ty = entM.find(Type.class, id);
		return ty;
	}

	/**
	 * Finds  pokemons by its type.
	 * @return The matching pokemon, otherwise null.
	 * @throws SQLException 
	 */
	public Pokemon findByType(Type ty) throws SQLException {
		List <Pokemon> allPokemons = null;
		// TODO:
		
		
		EntityManager entityManager = getEntityManager();
		TypedQuery<Pokemon> query = entityManager.
				createQuery("from Pokemon p , Pokemon_est_de_type pest , Type_pokemon tp"
				+ " where p.id = pest.pokemon_id "
				+ "and "
				+ "pest.type_id = tp.id"
				+ "and "
				+ "tp.label = :label"
				, Pokemon.class);
		query.setParameter("label", ty.getLabel());
		System.out.println(query.getResultList());
		allPokemons = query.getResultList();
		
		
		return (Pokemon) allPokemons;
	}
}
