package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonOwnerCell implements SmartCell{
	
	public String ask(Tweet question) {
		if (question.getText().contains("Owner ?"))
			return "No Owner";
		return null;
    }
	

}
