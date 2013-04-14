package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonKoCell implements SmartCell{
	static final int maxCarac = 140;
	public String ask(Tweet question) {
		
		// String owner = "Owner" ;

		if (PokeBot.getPvRestant() <= 0)
		{
			//Tweet Pkmn KO sans #PokeBattle
			String tweetKo = "#KO /cc " + "@" + question.getScreenName() 
					+ " @dresseurAdv " + question.getText().split(" ")[3];
			
			//Tweet Pkmn KO avec #PokeBattle
			String tweetKoPB = "#KO /cc " + "@" + question.getScreenName()
					+ " @dresseurAdv " + question.getText().split(" ")[3] + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(tweetKoPB.length() <= maxCarac) 
				return tweetKoPB;
			return tweetKo;
	
		}	
		return null;
    }
	

}
