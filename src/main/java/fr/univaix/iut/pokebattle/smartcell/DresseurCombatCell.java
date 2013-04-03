package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurCombatCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
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
			
			return "@" + question.getScreenName() + " #fight #ok with " + "@monPokemon" + " /cc " + juge;
		}
		
		if (emetteur.equals("fantomiinus") || emetteur.equals("pikachu")) {
		System.out.println("test 1");
			if (question.getText().split(" ")[0].toLowerCase().equals("@onix__")
				&& question.getText().contains("#attack"))
			{
				
				System.out.println("test 2");
				String pokemon = question.getText().split(" ")[0];
				String dresseurAdv = question.getText().split(" ")[5];
				String pokemonAdv = question.getScreenName();	
				String juge = question.getText().split(" ")[6];
				return pokemon + " #attack #roche " + "@" + pokemonAdv
					+ " /cc " + dresseurAdv + " " + juge + " #" + JudgeBot.getNumRound();
			}
		}
		return null;
    }
	

}
