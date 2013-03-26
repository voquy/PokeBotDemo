package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeCombatCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		String emetteur = "@" +  question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (question.getText().toLowerCase().contains("#ko")) {
			if(emetteur.toLowerCase().equals(JudgeBot.getPokemonDress1().toLowerCase()))
				return JudgeBot.getPokemonDress2() + " #Win";
			
			return JudgeBot.getPokemonDress1() + " #Win";	
		}
		
		if (emetteur.equals("@fantomiinus") || emetteur.equals("@pikachu")) {
		
			if (question.getText().contains("#attack"))
			{
				String pokemonAttaqué = question.getText().split(" ")[0];
				String dresseur = question.getText().split("/cc")[1];
				String dresseursubit = dresseur.split(" ")[1];	
				return pokemonAttaqué + " -10pv /cc " + dresseursubit;
			}
		}
		
		return null;
    }
	

}
