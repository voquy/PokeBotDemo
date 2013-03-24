package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class DresseurCombatCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if(question.getText().contains("#fight") &&  question.getText().contains("with @")){
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
				return pokemon + " #attack #roche " + pokemonAdv + " /cc " + dresseurAdv + " " + juge;
			}
		}
		return null;
    }
	

}
