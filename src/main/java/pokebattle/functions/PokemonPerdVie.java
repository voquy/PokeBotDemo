package pokebattle.functions;

import fr.univaix.iut.pokebattle.PokeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class PokemonPerdVie implements SmartCell {

    public String ask(Tweet question) {
		
		if (question.getScreenName().toLowerCase().equals("jugecordier")) {
			PokeBot.setVie(PokeBot.getVie() - 10);
			if (PokeBot.getVie() <= 0)
				return "#KO /cc " + question.getScreenName() + " @dresseurAdv " + question.getText().split(" ")[3];
			return "Ma vie : " + String.valueOf(PokeBot.getVie());
		}
		return null;
    }

}
