package BD.java.fr.univaix.iut.progbd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.run.PokemonMain;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.twitter.TwitterBuilder;
 
public class Main {

    public static void Creer() {
        // Initializes the Entity manager
 
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
       EntityManager em = emf.createEntityManager();
    
        

        Pokemon Fantomiinus = new Pokemon("Fantomiinus");
        DAOPokemonJPA dao = new DAOPokemonJPA(em);
        Pokemon Evoli = new Pokemon ("Evoli_iut");
        Evoli.setBaseHP(55);
        Evoli.setLevel(1);
        Evoli.setHPTotal(55);
        Evoli.setOwner("jeremsboot");
        Evoli.setExp(1);
        Evoli.setTrueName("Évoli");
       	Fantomiinus.setBaseHP(10);
       	Fantomiinus.setLevel(1);
       	Fantomiinus.setOwner("graiig1");
       	Fantomiinus.setHPTotal(60);
       	Fantomiinus.setExp(1);
       	Fantomiinus.setTrueName("fantominus");
       	dao.insert(Fantomiinus);
       	dao.insert(Evoli);
       	em.persist(Evoli);
        em.persist(Fantomiinus);
        InputStream inputStream = getResourceAsStream("PkmFantominus.properties");
		Credentials credentials = new Credentials();

		try {
			credentials = Credentials.loadCredentials(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TwitterBuilder builder = new TwitterBuilder(credentials);
		Twitter twitter = builder.build();

		try {
			if ( Fantomiinus.getOwner()==null)
				twitter.updateProfile(null, null, null,
					"#pokebattle - #pokemon - Level: "+Fantomiinus.getLevel() + " Owner: @" + Fantomiinus.getOwner());
			else 
				twitter.updateProfile(null, null, null,
				"#pokebattle - #pokemon - Level: "+Fantomiinus.getLevel() + " #Sauvage");

		} catch (TwitterException e) {
			e.printStackTrace();
		}

       

        
    }

	private static InputStream getResourceAsStream(String string) {
		// TODO Auto-generated method stub
		return PokemonMain.class.getClassLoader().getResourceAsStream(string);
	}
}
