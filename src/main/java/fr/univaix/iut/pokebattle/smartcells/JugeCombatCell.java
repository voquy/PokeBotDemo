package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class JugeCombatCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		System.out.println("Attack"+question.getText());
		
		String emetteur = question.getScreenName().toLowerCase();
		
		System.out.println("Emetteur : " + emetteur);
		
		if (emetteur.equals("fantomiinus") || emetteur.equals("pikachu")) {
		
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
