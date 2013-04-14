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
				JudgeBot.setNumRound(JudgeBot.getNumRound()+1);
					String tweetRound = "Round #" + JudgeBot.getNumRound() + " /cc @"+ JudgeBot.getAdversaire2() + " "
					+ JudgeBot.getPokemonDress2() + " @" + JudgeBot.getAdversaire1() + " "
					+ JudgeBot.getPokemonDress1();
					String tweetRoundPB = "Round #" + JudgeBot.getNumRound() + " /cc @"+ JudgeBot.getAdversaire2() + " "
							+ JudgeBot.getPokemonDress2() + " @" + JudgeBot.getAdversaire1() + " "
							+ JudgeBot.getPokemonDress1() + " #PokeBattle";
					if(tweetRoundPB.length() <= 140) 
						return tweetRoundPB;
					else
						return tweetRound;
			}
			
		}
		return null;
    }

}
