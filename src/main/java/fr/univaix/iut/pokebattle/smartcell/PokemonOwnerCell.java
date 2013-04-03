package fr.univaix.iut.pokebattle.smartcell;

import java.util.regex.Pattern;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell{
	


	public String ask(Tweet question) {
		
		// String owner = "Owner" ;
		String texte =  question.getText().toLowerCase();  // texte à tester    
		boolean b = Pattern.matches(".*own.*", texte);
		if (b)

		{
			if (PokeBot.owner == null)
				return "@" + question.getScreenName() + " No Owner";
			else
				return "@" + question.getScreenName() + " " + "@" + PokeBot.owner + " is My Owner!!!!";
		}	
		return null;
    }
	

}
