package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell{
	


	public String ask(Tweet question) {
		String PokeCible=question.getText().split("@")[1];
		String PokeMonCible=PokeCible.split(" ")[0];
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
	    EntityManager em = emf.createEntityManager();
	    
	    DAOPokemonJPA dao = new DAOPokemonJPA(em);
	    Pokemon Fantomiinus = dao.getById(PokeMonCible);
		// String owner = "Owner" ;
		if (question.getText().contains("Owner ?"))
		{
			if (Fantomiinus.getOwner() == null){
				System.out.println(Fantomiinus);
				return "@" + question.getScreenName() + " No Owner";
			}
			else
				return "@" + question.getScreenName() + " " + "@" + Fantomiinus.getOwner() + " is My Owner";
		}	
		return null;
    }
	

}
