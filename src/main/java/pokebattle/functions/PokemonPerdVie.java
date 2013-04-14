package pokebattle.functions;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


/**
 * Reply to all.
 */
public class PokemonPerdVie implements SmartCell {
	static final int maxCarac = 140;
    public String ask(Tweet question) {
		
		if (question.getScreenName().equalsIgnoreCase("jugecordier")) {
			PokeBot.setPvRestant(PokeBot.getPvRestant() - 10);
			// Pour avoir une valeur de sauvegarde
			PokeBot.setPvRestantLast(PokeBot.getPvRestant());
			
			if (PokeBot.getPvRestant() <= 0)
			{	
				//Tweet KO sans #PokeBattle
				String tweetKo = "#KO /cc @" + question.getScreenName() + " @dresseurAdv "
						+ question.getText().split(" ")[3];
				
				//Tweet KO avec #PokeBattle
				String tweetKoPB = "#KO /cc @" + question.getScreenName() + " @dresseurAdv "
						+ question.getText().split(" ")[3] + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(tweetKoPB.length() <= maxCarac) 
					return tweetKoPB;
				else
					return tweetKo;
			
			}
			
			//Tweet vie sans #PokeBattle
			String tweetVie = "Ma vie : " + String.valueOf(PokeBot.getPvRestant());
			
			//Tweet KO avec #PokeBattle
			String tweetViePB = "Ma vie : " + String.valueOf(PokeBot.getPvRestant()) + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(tweetViePB.length() <= maxCarac) 
				return tweetViePB;
			else
				return tweetVie;	
		}
		return null;
    }

}
