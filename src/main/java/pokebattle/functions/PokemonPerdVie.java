package pokebattle.functions;

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
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();

		DAOPokemonJPA dao = new DAOPokemonJPA(em);
		Pokemon Fantomiinus = dao.getById("Fantomiinus");
		int actualPV= Fantomiinus.getBaseHP();
		if (question.getScreenName().toLowerCase().equals("jugecordier")) {

			actualPV = actualPV -10;
			Fantomiinus.setBaseHP(actualPV);
			boolean update = dao.update(Fantomiinus);
			System.out.println(Fantomiinus.getBaseHP());
		/*	if (actualPV <= 0)
				return "#KO /cc " + question.getScreenName() + " @dresseurAdv " + question.getText().split(" ")[3];
			return "Ma vie : " + String.valueOf(Fantomiinus.getBaseHP());
*/
			PokeBot.setPVRestant(PokeBot.getPVRestant() - 10);
			// Pour avoir une valeur de sauvegarde
			PokeBot.setPVRestantLast(PokeBot.getPVRestant());
			
			if (Fantomiinus.getBaseHP() <= 0)
				return "#KO /cc @" + question.getScreenName() + " @dresseurAdv " + question.getText().split(" ")[3];
			return "Ma vie : " + Fantomiinus.getBaseHP();

		}
		return null;
    }

}
