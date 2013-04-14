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
			String tweetDc = "@" + question.getScreenName() 
					+ " #fight #ok with " + "@monPokemon" + " /cc " + juge;
			
			//Tweet déclaration combat avec #PokeBattle
			String tweetDcPB = "@" + question.getScreenName() 
					+ " #fight #ok with " + "@monPokemon" + " /cc " + juge + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(tweetDcPB.length() <= maxCarac) 
				return tweetDcPB;
			else
				return tweetDc;
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
				String tweetDa = pokemon + " #attack #roche " + "@" + pokemonAdv 
						+ " /cc " + dresseurAdv + " " + juge + " #" + JudgeBot.getNumRound();
				
				//Tweet déclare attack avec #PokeBattle
				String tweetDaPB = pokemon + " #attack #roche " + "@" + pokemonAdv
						+ " /cc " + dresseurAdv + " " + juge + " #"
						+ JudgeBot.getNumRound() + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(tweetDaPB.length() <= maxCarac) 
					return tweetDaPB;
				return tweetDa;
			}
		}
		return null;
    }
	
}
