package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurCombatCell implements SmartCell{
	static final int maxCarac = 140;
	
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		// Junit Test
		/*
		if(question.getText().contains("#fight with @")){
			String juge = "@jugecordier";
			String emetteurTweet = "dresseur";
			
			return "@" + emetteurTweet + " #fight #ok with " + "@monPokemon" + " /cc " + juge;
		}
		*/
		
		if(question.getText().contains("#fight with @")){
			String juge = question.getText().split(" ")[5];
			
			//Tweet déclaration combat sans #PokeBattle
			String TweetDC = "@" + question.getScreenName() 
					+ " #fight #ok with " + "@monPokemon" + " /cc " + juge;
			
			//Tweet déclaration combat avec #PokeBattle
			String TweetDCPB = "@" + question.getScreenName() 
					+ " #fight #ok with " + "@monPokemon" + " /cc " + juge + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetDCPB.length() <= maxCarac) 
				return TweetDCPB;
			else
				return TweetDC;
		}
		
		if (emetteur.equals("fantomiinus") || emetteur.equals("pikachu")) {
			if (question.getText().split(" ")[0].toLowerCase().equals("@onix__")
				&& question.getText().contains("#attack"))
			{
				String pokemon = question.getText().split(" ")[0];
				String dresseurAdv = question.getText().split(" ")[5];
				String pokemonAdv = question.getScreenName();	
				String juge = question.getText().split(" ")[6];
				
				//Tweet déclare attack sans #PokeBattle
				String TweetDA = pokemon + " #attack #roche " + "@" + pokemonAdv 
						+ " /cc " + dresseurAdv + " " + juge + " #" + JudgeBot.getNumRound();
				
				//Tweet déclare attack avec #PokeBattle
				String TweetDAPB = pokemon + " #attack #roche " + "@" + pokemonAdv
						+ " /cc " + dresseurAdv + " " + juge + " #"
						+ JudgeBot.getNumRound() + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(TweetDAPB.length() <= maxCarac) 
					return TweetDAPB;
				return TweetDA;
			}
		}
		return null;
    }
	
}
