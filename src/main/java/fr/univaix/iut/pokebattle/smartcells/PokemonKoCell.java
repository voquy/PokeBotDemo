package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.PokeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonKoCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		// String owner = "Owner" ;

		if (PokeBot.vie <= 0)
		{
			return "#KO /cc " + question.getScreenName() + " @dresseurAdv " + question.getText().split(" ")[3];
		}	
		return null;
    }
	

}
