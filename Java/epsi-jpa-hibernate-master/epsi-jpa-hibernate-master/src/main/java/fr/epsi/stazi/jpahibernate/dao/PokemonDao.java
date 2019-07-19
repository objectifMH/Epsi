package fr.epsi.stazi.jpahibernate.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.epsi.stazi.jpahibernate.dao.helper.DatabaseHelper;
import fr.epsi.stazi.jpahibernate.model.Pokemon;

public class PokemonDao extends GenericDao {

    /**
     * Insers a pokemon.
     *
     * @throws SQLException
     */
    public void insert(Pokemon pokemon) throws SQLException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager); // on ouvre une transaction 
        entityManager.persist(pokemon);
        DatabaseHelper.commitTransactionAndClose(entityManager); // on commit pour envoyer en BD 
        System.out.println("Pokemon " + pokemon + "a bien été ajouté en bd");

    }

    
    public void update(Pokemon pokemon) throws SQLException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager); // on ouvre une transaction 
        Pokemon managedPokemon = entityManager.find(Pokemon.class, pokemon.getId());
        // Les set sont instantan�s dans la base parce que l'entit� est Managed
        managedPokemon.setName(pokemon.getName());
        managedPokemon.setNumber(pokemon.getNumber());
        managedPokemon.setHealthPoints(pokemon.getHealthPoints());
        managedPokemon.setEvolution(pokemon.getEvolution()); // entityManager.find(Pokemon.class, pokemon.getEvolution().getId())
        DatabaseHelper.commitTransactionAndClose(entityManager); // on commit pour envoyer en BD 
        System.out.println("Pokemon " + pokemon + "a bien été update en bd");

    }

    public void update2(Pokemon pokemon) throws SQLException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager); // on ouvre une transaction 
        entityManager.merge(pokemon);
        DatabaseHelper.commitTransactionAndClose(entityManager); // on commit pour envoyer en BD 
        System.out.println("Pokemon " + pokemon + "a bien été update en bd");

    }

    /**
     * Finds all pokemons.
     *
     * @return A list containing all the pokemons.
     * @throws SQLException
     */
    public List<Pokemon> findAll() throws SQLException {

        EntityManager entityManager = getEntityManager();
        TypedQuery<Pokemon> query = entityManager.createQuery("from Pokemon", Pokemon.class);
        List<Pokemon> allPokemons = query.getResultList();

        return allPokemons;
    }

    /**
     * Finds a pokemon by its id.
     *
     * @return The matching pokemon, otherwise null.
     * @throws SQLException
     */
    public Pokemon findById(long id) throws SQLException {
        Pokemon pokemon = null;

        // TODO:
        EntityManager entM = getEntityManager();
        pokemon = entM.find(Pokemon.class, id);
        System.out.println("Pokemon trouvé : "+ pokemon );
        return pokemon;
    }

    /**
     * Finds a pokemon by its number.
     *
     * @return The matching pokemon, otherwise null.
     * @throws SQLException
     */
    public Pokemon findByNumber(int number) throws SQLException {
        Pokemon pokemon = null;

        EntityManager entityManager = getEntityManager();
        TypedQuery<Pokemon> query = entityManager.
                createQuery("from Pokemon p"
                        + " where p.number "
                        + "= :number ",
                         Pokemon.class);
        query.setParameter("number", number);
        pokemon = query.getSingleResult();

        return pokemon;
    }

    public void deleteById(long id) {
        EntityManager entityManager = getEntityManager();
        Pokemon po = entityManager.find(Pokemon.class, id);
        
        System.out.println("Pokemon " + po + "va etre  supprimer de la  bd");

        DatabaseHelper.beginTransaction(entityManager); // on ouvre une transaction 
        entityManager.remove(po);
        DatabaseHelper.commitTransactionAndClose(entityManager); // on commit pour envoyer en BD 
        
    }

}
