package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonOwnerCell implements SmartCell{
	
	public String ask(Tweet question) {

		
		if (question.getText().contains("Owner ?"))
		{
				String reponse = "@" + question.getScreenName() + " " + "@owner" + " is My Owner";
				Tweet tweet_rep = new Tweet(reponse);
				String pokemon = tweet_rep.getScreenName();
				Tweet ordre_attaque = new Tweet ("@" + pokemon + "#attack #foudre " + "@pokemon_adv");
				return "@pokemon_adv " + "#attack #foudre! /cc " + "@" + question.getScreenName();
				
		}
				
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
