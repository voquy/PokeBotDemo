package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonAttackCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (emetteur.equals("quynhchee") || emetteur.equals("jeremsboot") || emetteur.equals("dounouw")
				|| emetteur.equals("graiig1") || emetteur.equals("brownrock_")) {
			if (question.getText().contains("#attack"))
			{
				String dresseuradverse = question.getText().split(" ")[5];
				String juge = question.getText().split(" ")[6];
				String attaque = question.getText().split(" ")[1]
								+ " " + question.getText().split(" ")[2]
								+ " " + question.getText().split(" ")[4];
				String pokemonAttaqué = question.getText().split(" ")[3];
				
				return pokemonAttaqué + " " + attaque + " " + dresseuradverse
						+ " @" + question.getScreenName() + " " + juge;
			}
		}
		return null;
    }
	

}
