package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonKoCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		// String owner = "Owner" ;

		if (PokeBot.vie <= 0)
		{
			return "#KO /cc " + "@" + question.getScreenName()
					+ " @dresseurAdv " + question.getText().split(" ")[3];
		}	
		return null;
    }
	

}
