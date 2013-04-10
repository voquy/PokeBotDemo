package pokebattle.functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonPerdVie implements SmartCell {

	public String ask(Tweet question) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();
		
		DAOPokemonJPA dao = new DAOPokemonJPA(em);

		System.out.println("Perd vie :" + question.getText());

		Pattern pattern = Pattern
				.compile("@([^ ]*) #attack #([^ ]*) /cc @([^ ]*) @([^ ]*) @([^ ]*)");
		Matcher matcher = pattern.matcher(question.getText());
		
		if (matcher.matches()) {

			String pokemonVise = matcher.group(1);
			String dresseurVise = matcher.group(4);
			String dresseurAdverse = matcher.group(3);
			
			//
			System.out.println("pokemon vise perd vie : " + pokemonVise);
			Pokemon Fantomiinus = dao.getById(pokemonVise);
			System.out.println("tweet perd vie : " + question.getText());
			System.out.println("Pokemon visee Perd Vie : " + Fantomiinus);
			int actualPV = Fantomiinus.getBaseHP();
			if (question.getScreenName().toLowerCase().equals("jugecordier")) {

				actualPV = actualPV - 10;
				Fantomiinus.setBaseHP(Fantomiinus.getBaseHP()-10);
				boolean update = dao.update(Fantomiinus);
				System.out.println(Fantomiinus.getBaseHP());
				/*
				 * if (actualPV <= 0) return "#KO /cc " +
				 * question.getScreenName() + " @dresseurAdv " +
				 * question.getText().split(" ")[3]; return "Ma vie : " +
				 * String.valueOf(Fantomiinus.getBaseHP());
				 */
				PokeBot.setPVRestant(PokeBot.getPVRestant() - 10);
				// Pour avoir une valeur de sauvegarde
				PokeBot.setPVRestantLast(PokeBot.getPVRestant());

				if (Fantomiinus.getBaseHP() <= 0)
					return "#KO /cc @" + question.getScreenName() + " @"
							+ Fantomiinus.getOwner() + " @"
							+ dresseurAdverse;
				return "Ma vie : " + Fantomiinus.getBaseHP();

			}
		}
		System.out.println("SA a par MARCHER");
		return null;
	}

}
