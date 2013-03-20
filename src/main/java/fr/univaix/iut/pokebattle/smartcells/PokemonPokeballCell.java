package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonPokeballCell implements SmartCell{
	
	public String ask(Tweet question) {

		
		if (question.getText().contains("Pokeball !"))
		{
			// if (owner == null)
				return "@" + question.getScreenName() + " is My Owner";
			// else
				//return "@" + question.getScreenName() + "@" + owner + " is My Owner";
		}
		return null;
    }
	

}
