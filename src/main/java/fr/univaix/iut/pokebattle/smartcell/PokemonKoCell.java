package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonKoCell implements SmartCell{
	static final int maxCarac = 140;
	public String ask(Tweet question) {
		
		// String owner = "Owner" ;

		if (PokeBot.pvRestant <= 0)
		{
			//Tweet Pkmn KO sans #PokeBattle
			String TweetKO = "#KO /cc " + "@" + question.getScreenName() 
					+ " @dresseurAdv " + question.getText().split(" ")[3];
			
			//Tweet Pkmn KO avec #PokeBattle
			String TweetKOPB = "#KO /cc " + "@" + question.getScreenName()
					+ " @dresseurAdv " + question.getText().split(" ")[3] + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetKOPB.length() <= maxCarac) 
				return TweetKOPB;
			else
				return TweetKO;
	
		}	
		return null;
    }
	

}
