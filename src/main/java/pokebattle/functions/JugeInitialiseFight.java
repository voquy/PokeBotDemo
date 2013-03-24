package pokebattle.functions;

import fr.univaix.iut.pokebattle.JugeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class JugeInitialiseFight implements SmartCell {

    public String ask(Tweet question) {
		
		if (question.getText().contains("#fight with")) {
			JugeBot.setAdversaire1(question.getScreenName());
		}
		
		if (question.getText().contains("#fight #ok with")) {
			JugeBot.setAdversaire2(question.getScreenName());
		}
		return "Combat entre " + JugeBot.getAdversaire1() + " et " + JugeBot.getAdversaire2();
    }

}
