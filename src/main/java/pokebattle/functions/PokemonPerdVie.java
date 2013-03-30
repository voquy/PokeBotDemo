package pokebattle.functions;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


/**
 * Reply to all.
 */
public class PokemonPerdVie implements SmartCell {

    public String ask(Tweet question) {
		
		if (question.getScreenName().toLowerCase().equals("jugecordier")) {
			PokeBot.setPVRestant(PokeBot.getPVRestant() - 10);
			// Pour avoir une valeur de sauvegarde
			PokeBot.setPVRestantLast(PokeBot.getPVRestant());
			
			if (PokeBot.getPVRestant() <= 0)
				return "#KO /cc @" + question.getScreenName() + " @dresseurAdv " + question.getText().split(" ")[3];
			return "Ma vie : " + String.valueOf(PokeBot.getPVRestant());
		}
		return null;
    }

}
