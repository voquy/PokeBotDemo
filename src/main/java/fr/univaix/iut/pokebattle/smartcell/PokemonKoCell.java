package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonKoCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		// String owner = "Owner" ;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();
		DAOPokemonJPA dao = new DAOPokemonJPA(em);
		Pokemon Poke = dao.getById("Fantomiinus");
		Pokemon PokeAdv = dao.getById("Evoli_iut");
		int pvRestant = Poke.getBaseHP();    
		if (pvRestant <= 0)
		{
			return "#KO /cc " + "@" + question.getScreenName()
					+ " @" + PokeAdv.getOwner()+ question.getText().split(" ")[3];
		}	
		return null;
    }
	

}
