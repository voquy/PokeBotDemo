package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonAttackCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		System.out.println("Attack"+question.getText());
		if (question.getText().contains("#attack"))
		{
			String dresseuradverse = question.getText().split("/cc")[1].trim();
					
			//if (owner == null)
				//return "@" + question.getScreenName() + " @" + owner + " is my owner";
			//else
				return "@pikachu #attack #ténèbres! /cc " + dresseuradverse + " @" + question.getScreenName();
		}
		return null;
    }
	

}
