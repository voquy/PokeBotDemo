package pokebattle.functions;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
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
			{	
				//Tweet KO sans #PokeBattle
				String TweetKO = "#KO /cc @" + question.getScreenName() + " @dresseurAdv "
						+ question.getText().split(" ")[3];
				
				//Tweet KO avec #PokeBattle
				String TweetKOPB = "#KO /cc @" + question.getScreenName() + " @dresseurAdv "
						+ question.getText().split(" ")[3] + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(TweetKOPB.length() <= 140) 
					return TweetKOPB;
				else
					return TweetKO;
			
			}
			
			//Tweet vie sans #PokeBattle
			String TweetV = "Ma vie : " + String.valueOf(PokeBot.getPVRestant());
			
			//Tweet KO avec #PokeBattle
			String TweetVPB = "Ma vie : " + String.valueOf(PokeBot.getPVRestant()) + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetVPB.length() <= 140) 
				return TweetVPB;
			else
				return TweetV;	
		}
		return null;
    }

}
