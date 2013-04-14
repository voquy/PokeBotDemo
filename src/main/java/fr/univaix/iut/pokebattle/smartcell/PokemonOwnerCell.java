package fr.univaix.iut.pokebattle.smartcell;

import java.util.regex.Pattern;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell{
	static final int maxCarac = 140;

	public String ask(Tweet question) {
		
		// String owner = "Owner" ;
		// texte à tester  
		String texte =  question.getText().toLowerCase();  
		boolean b = Pattern.matches(".*own.*", texte);
		if (b)

		{
			if (PokeBot.getOwner() == null)
			{
				//Tweet Pkmn pas own par le dresseur sans #PokeBattle
				String tweetNo ="@" + question.getScreenName() + " No Owner";
				
				//Tweet Pkmn pas own par le dresseur avec #PokeBattle
				String tweetNoPB ="@" + question.getScreenName() + " No Owner" + " #PokeBattle";
				
				//Si le tweet fait moins de 140 caractères
				if(tweetNoPB.length() <= maxCarac)
					return tweetNoPB;
				return tweetNo;
			}
			else
			{
				//Tweet Pkmn own par le dresseur sans #PokeBattle
				String tweetOwn = "@" + question.getScreenName()
						+ " " + "@" + PokeBot.getOwner() + " is My Owner!!!!";
				
				//Tweet Pkmn own par le dresseur avec #PokeBattle
				String tweetOwnPB = "@" + question.getScreenName()
						+ " " + "@" + PokeBot.getOwner() + " is My Owner!!!!" + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(tweetOwnPB.length() <= maxCarac) 
					return tweetOwnPB;
				return tweetOwn;
		
			}
		}
		return null;
    }
}
