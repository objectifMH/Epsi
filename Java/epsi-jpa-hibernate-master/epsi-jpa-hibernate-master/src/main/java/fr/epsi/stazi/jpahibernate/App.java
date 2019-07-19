package fr.epsi.stazi.jpahibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epsi.stazi.jpahibernate.dao.*;
import fr.epsi.stazi.jpahibernate.dao.helper.DatabaseHelper;
import fr.epsi.stazi.jpahibernate.model.Dresseur;
import fr.epsi.stazi.jpahibernate.model.Pokemon;
import fr.epsi.stazi.jpahibernate.model.Type;

public class App {

    private static PokemonDao pdao = new PokemonDao();
    private static TypeDao tdao = new TypeDao();
    //private static DresseurDao ddao = new DresseurDao();

    public static List<Type> getListePoison() throws SQLException {
        //liste Poison 
        Type tpoison = new Type();
        tpoison = tdao.findById(2); //2  est l'id du type poison
        List<Type> listeTypePoison = new ArrayList<>();
        listeTypePoison.add(tpoison);
        return listeTypePoison;

    }

    public static List<Type> getListeSol() throws SQLException {
        //liste Sol 
        Type t = new Type();
        t = tdao.findById(9); //9 est l'id du type sol 
        List<Type> listeTypeSol = new ArrayList<>();
        listeTypeSol.add(t);
        return listeTypeSol;

    }

    public static void editDresseur() throws SQLException{
        
        Dresseur dresseur = new Dresseur();
        List <Pokemon> listPo  = new ArrayList<>();
        
        System.out.println("Rentrez le nom du nouveau Dresseur");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        dresseur.setNom(name);
        
        
        System.out.println("Rentrez la Ville de "+ name);
        sc = new Scanner(System.in);
        String ville = sc.nextLine();
        dresseur.setVille(ville);

        System.out.println("On va creer la liste des pokemons du dresseur : " + name);
        System.out.println("Combien de Pokemons voulez vous lui rajouter ? ");
        sc = new Scanner(System.in);
        int nb = sc.nextInt();
        
        for ( int i = 0 ; i < nb ; i++)
        {
            System.out.println("Quel est l'id du pokemon : "+ (i+1) );
            sc = new Scanner(System.in);
            long idPo = sc.nextLong();
            
            System.out.println(dresseur+ "  >>>>   "+idPo + " >>>> "+ pdao.findById(idPo));
            ;
            listPo.add(pdao.findById(idPo));
            System.out.println(listPo);
            
            
            
        }

       // dresseur.setListPokemon(listPo);
       // ddao.insert(dresseur);

        
        
        
        
    }
    
    public static void editPokemon() throws SQLException {

        Pokemon pok = new Pokemon();

        System.out.println("Rentrez le nom du nouveau pokemon");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        pok.setName(name);

        System.out.println("Rentrez le num�ro du  pokemon" + name);
        sc = new Scanner(System.in);
        int number = sc.nextInt();
        pok.setNumber(number);

        System.out.println("Rentrez le type du  pokemon" + name);
        System.out.println("1: Sol , 2:Poison");
        sc = new Scanner(System.in);
        int typ = sc.nextInt();

        if (typ == 1) {
            pok.setTypes(getListeSol());
        }
        if (typ == 2) {
            pok.setTypes(getListePoison());
        }

        System.out.println("Rentrez le nombre de points du  pokemon" + name);
        sc = new Scanner(System.in);
        int hp = sc.nextInt();
        pok.setHealthPoints(hp);

        pdao.insert(pok);

        System.out.println("Voulez vous mettre a jours l'evolution d'un pokemon ?");
        System.out.println("Donnez Son id ");
        sc = new Scanner(System.in);
        int id = sc.nextInt();

        Pokemon poUpd = new Pokemon();
        poUpd = pdao.findById(id);

        System.out.println("Donnez l'id de l'�volution  ");
        sc = new Scanner(System.in);
        int idEvo = sc.nextInt();

        Pokemon poEvo = new Pokemon();
        poEvo = pdao.findById(idEvo);

        poUpd.setEvolution(poEvo);

        //update
        poUpd.setName(poUpd.getName() + " - upd");
        pdao.update2(poUpd);

    }

    public static void deletePokemonById(PokemonDao pdao , int id) throws SQLException {

        pdao.deleteById(id);
        
    }

    public static void main(String[] args) throws SQLException {

        System.out.println("Welcome dans ton pokedex !");
        
        //System.out.println(pdao.findByNumber(2));

        // /*
        System.out.println("Est ce que vous voulez Ajouter un Pokemon ? ");
        System.out.println("1: OUI , 2:NON");
        Scanner sc = new Scanner(System.in);
        int aj = sc.nextInt();
        if ( aj == 1 )
        editPokemon();

        System.out.println("Est ce que vous voulez Supprimez un Pokemon ? ");
        System.out.println("1: OUI , 2:NON");

        
        int rep = sc.nextInt();

        if (rep == 1) {
            
            System.out.println("Quel est l'id du Pokemon a supprimer ? ");
            sc = new Scanner(System.in);
            int idSupp = sc.nextInt();

            deletePokemonById(pdao , idSupp);
        }
        //
                if (rep == 2) {
            System.exit(0);
        }
        //

        
        System.out.println("Est ce que vous voulez Ajouter un Dresseur ? ");
        System.out.println("1: OUI , 2:NON");

        
        int dres = sc.nextInt();

        if (dres == 1) {
            
            editDresseur();
        }
        // */
        
        // pokemon au num�ro 12
        /*
		System.out.println("Le pokemon qui a pour num�ro 12 "); 
		Pokemon p = pdao.findByNumber(12);
		System.out.println(p);
         */
        //pokemonDao.findAll().forEach(p -> System.out.println(p));
        // TODO: Appeler le DAO pour r�cup�rer la liste de tous les Pokemon pr�sents en base de donn�es
        /*
		PokemonDao pokemonDao = new PokemonDao();
		for ( Pokemon pok : pokemonDao.findAll() )
		{
			System.out.println(pok);
		}
        */
        // TODO: Ins�rer les 8 Pokemon suivants du pok�dex (cf. https://www.pokepedia.fr/Liste_des_Pok%C3%A9mon_dans_l%27ordre_du_Pok%C3%A9dex_de_Kanto)
        // TODO: R�cup�rer le Pokemon d'id 9
        // TODO: R�cup�rer le Pokemon de num�ro 12
        DatabaseHelper.closeEntityManagerFactory();
    }

}
