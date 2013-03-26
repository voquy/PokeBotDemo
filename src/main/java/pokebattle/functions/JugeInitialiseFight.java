package pokebattle.functions;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class JugeInitialiseFight implements SmartCell {

    public String ask(Tweet question) {
    	
		if (question.getText().toLowerCase().contains("#fight")) {
			if (question.getText().contains("#fight with")) {
				JudgeBot.setAdversaire1(question.getScreenName());
				JudgeBot.setPokemonDress1(question.getText().split(" ")[3]);
			}
			
			if (question.getText().contains("#fight #ok with")) {
				JudgeBot.setAdversaire2(question.getScreenName());
				JudgeBot.setPokemonDress2(question.getText().split(" ")[4]);
			}
			return "Combat engagé entre " + JudgeBot.getAdversaire1() + " et " + JudgeBot.getAdversaire2();
		}
		return null;
    }

}
