package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.PokeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonOwnerCell implements SmartCell{
	


	public String ask(Tweet question) {
		
		// String owner = "Owner" ;

		if (question.getText().contains("Owner ?"))
		{
		
		if (PokeBot.owner == null)
			return "@" + question.getScreenName() + " No Owner";
		else
			return "@" + question.getScreenName() + " " + "@" + PokeBot.owner + " is My Owner";
		}	
		return null;
    }
	

}
