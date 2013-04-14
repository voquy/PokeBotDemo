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
			if (PokeBot.owner == null)
			{
				//Tweet Pkmn pas own par le dresseur sans #PokeBattle
				String TweetNO ="@" + question.getScreenName() + " No Owner";
				
				//Tweet Pkmn pas own par le dresseur avec #PokeBattle
				String TweetNOPB ="@" + question.getScreenName() + " No Owner" + " #PokeBattle";
				
				//Si le tweet fait moins de 140 caractères
				if(TweetNOPB.length() <= maxCarac)
					return TweetNOPB;
				return TweetNO;
			}
			else
			{
				//Tweet Pkmn own par le dresseur sans #PokeBattle
				String TweetO = "@" + question.getScreenName()
						+ " " + "@" + PokeBot.owner + " is My Owner!!!!";
				
				//Tweet Pkmn own par le dresseur avec #PokeBattle
				String TweetOPB = "@" + question.getScreenName()
						+ " " + "@" + PokeBot.owner + " is My Owner!!!!" + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(TweetOPB.length() <= maxCarac) 
					return TweetOPB;
				return TweetO;
		
			}
		}
		return null;
    }
}
