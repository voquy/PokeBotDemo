package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import pokebattle.functions.PokemonAttackValide;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonAttackCell implements SmartCell{
	
	public String ask(Tweet question) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
	    EntityManager em = emf.createEntityManager();
	    
	    DAOPokemonJPA dao = new DAOPokemonJPA(em);
	    Pokemon Fantomiinus = dao.getById("Fantomiinus");
	    System.out.println(Fantomiinus);
		String emetteur = question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis 2: " + question.getText());
		System.out.println("Emetteur : 2" + emetteur);
		
		System.out.println(Fantomiinus);
		System.out.println("coucou");
		
		if (emetteur.toLowerCase().equals("quynhchee")
			|| emetteur.toLowerCase().equals("jeremsboot") || emetteur.toLowerCase().equals("dounouw")
			|| emetteur.toLowerCase().equals("graiig1") || emetteur.toLowerCase().equals("brownrock_"))
		{
			if (question.getText().toLowerCase().contains("#attack"))
			{
				String text = question.getText().toLowerCase().split("#attack ")[1];
				String ok = text.split("#")[1];
				String nomAttaque = ok.split(" ")[0];
		/*
				String dresseuradverse = question.getText().split(" ")[5];
				String juge = question.getText().split(" ")[6];
				String attaque = question.getText().split(" ")[1]
								+ " " + question.getText().split(" ")[2]
								+ " " + question.getText().split(" ")[4];
				String pokemonAttaqué = question.getText().split(" ")[3];
		*/
				
				String pokemonRecoitTweet = question.getText().split(" ")[0];
				String rien = question.getText().split("@")[3];
				text = "@" + rien;
				String dresseurAdverse = text.split(" ")[0];
				String juge = "@" + question.getText().split("@")[4];
				rien = question.getText().split("@")[2];
				text = "@" + rien;
				String pokemonVise = text.split(" ")[0];
				
				if (PokemonAttackValide.run(Fantomiinus.getTrueName(), nomAttaque, Fantomiinus.getLevel()))
				{	/*				
					return pokemonAttaqué + " " + attaque + " " + dresseuradverse
							+ " @" + question.getScreenName() + " " + juge;
					*/
					
					// Sauvegarde la date-heure de la dernière attaque du pokemon
					Fantomiinus.setLastAttack(question.getDate()) ;
					dao.update(Fantomiinus);
					System.out.println(Fantomiinus);
					return pokemonVise + " #attack #" + nomAttaque + " /cc "
							+ dresseurAdverse + " " + "@" + question.getScreenName()
							+ " " + juge;
				}
				
				return "@" + question.getScreenName() + " o_O ? /cc " + dresseurAdverse
						+ " " + juge + " " + pokemonVise;
			}
		}
		return null;
    }
	

}
