package fr.univaix.iut.pokebattle.smartcell;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import pokebattle.functions.JudgeCalculExpWin;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeCombatCell implements SmartCell{

	public String ask(Tweet question) {

		String emetteur = "@" +  question.getScreenName().toLowerCase();

		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
	    EntityManager em = emf.createEntityManager();
	    String PokeCible=question.getText().split("@")[1];
		String PokeMonCible=PokeCible.split(" ")[0];
	    DAOPokemonJPA dao = new DAOPokemonJPA(em);
	    Pokemon Fantomiinus = dao.getById(PokeMonCible);
	    Pokemon Evoli = dao.getById("Evoli_iut");
		if (question.getText().toLowerCase().contains("#ko")) {
			// Penser à ajouter l'exp gagné au pokémon vainqueur, faire un set
			if(emetteur.toLowerCase().equals(Fantomiinus.getName().toLowerCase()))
			{
																// PkmGagnant					PkmPerdant
				double expWin = JudgeCalculExpWin.calculExp(Evoli.getName(), Fantomiinus.getName());
				Evoli.setExp(expWin);
				System.out.println(expWin);
				boolean updateE = dao.update(Evoli);
				return Evoli.getName() + " #Win +" + expWin + "xp";
			}
																//	PkmGagnant					PkmPerdant
			double expWin = JudgeCalculExpWin.calculExp(Evoli.getName(), Fantomiinus.getName());
			Fantomiinus.setExp(expWin);	
			System.out.println(expWin);
			boolean epdateF = dao.update(Fantomiinus);
			return Fantomiinus.getName() + " #Win +" + expWin + "xp";
		}

		if (emetteur.equals("@fantomiinus") || emetteur.equals("@pikachu")) {

			if (question.getText().contains("#attack"))
			{
				String pokemonAttaqué = question.getText().split(" ")[0];
				String dresseur = question.getText().split("/cc")[1];
				String dresseursubit = dresseur.split(" ")[1];	
				return pokemonAttaqué + " -10pv /cc " + dresseursubit;
			}
		}

		return null;
    }


}