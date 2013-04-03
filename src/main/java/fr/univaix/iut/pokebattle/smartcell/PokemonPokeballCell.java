package fr.univaix.iut.pokebattle.smartcell;

import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.run.PokemonMain;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.twitter.TwitterBuilder;



public class PokemonPokeballCell implements SmartCell {
	@Override
	public String ask(Tweet question) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();

		DAOPokemonJPA dao = new DAOPokemonJPA(em);
		Pokemon Fantomiinus = dao.getById("Fantomiinus");
		if (question.getText().toLowerCase().contains("pokeball")) {
			System.out.println(PokeBot.getOwner());

			System.out.println(question.getScreenName());

			if (PokeBot.getOwner() == null) {


				Fantomiinus.setOwner(question.getScreenName());
				
				boolean update = dao.update(Fantomiinus);
				System.out.println(update);

				PokeBot.owner=Fantomiinus.getOwner();
				System.out.println(PokeBot.getOwner());
				System.out.println(Fantomiinus.getLevel());
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
					twitter.updateProfile(null, null, null,
							"#pokebattle - #pokemon - Level: "+Fantomiinus.getLevel() + " Owner: @" + Fantomiinus.getOwner());					
					return "@" + Fantomiinus.getOwner() + " You Are My Owner";

				} catch (TwitterException e) {
					e.printStackTrace();
				}


			}
			else if (PokeBot.getOwner().equals(question.getScreenName()))
				return "@" +Fantomiinus.getOwner()
						+ " You Are Already My Owner Bitch";
		}
		
			return "@" + question.getScreenName() + " @" + Fantomiinus.getOwner()
					+ " is My Owner";
			

	}
	
    
			static InputStream getResourceAsStream(String fileName) {
				return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
			}
		}