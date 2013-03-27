package fr.univaix.iut.pokebattle.smartcell;

import BD.java.fr.univaix.iut.progbd.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell{
	


	public String ask(Tweet question) {
		
		// String owner = "Owner" ;
		if (question.getText().contains("Owner ?"))
		{
			if (PokeBot.owner == null){
				
				return "@" + question.getScreenName() + " No Owner";
			}
			else
				return "@" + question.getScreenName() + " " + "@" + PokeBot.owner + " is My Owner";
		}	
		return null;
    }
	

}
