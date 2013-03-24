package pokebattle.functions;

import fr.univaix.iut.pokebattle.JugeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class JugeInitialiseFight implements SmartCell {

    public String ask(Tweet question) {
    	
		if (question.getText().toLowerCase().contains("#fight")) {
			if (question.getText().contains("#fight with")) {
				JugeBot.setAdversaire1(question.getScreenName());
				JugeBot.setPokemonDress1(question.getText().split(" ")[3]);
			}
			
			if (question.getText().contains("#fight #ok with")) {
				JugeBot.setAdversaire2(question.getScreenName());
				JugeBot.setPokemonDress2(question.getText().split(" ")[4]);
			}
			return "Combat engagé entre " + JugeBot.getAdversaire1() + " et " + JugeBot.getAdversaire2();
		}
		return null;
    }

}
