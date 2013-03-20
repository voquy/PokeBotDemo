package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonAttackCell implements SmartCell{
	
	public String ask(Tweet question) {
		
		System.out.println("Attack"+question.getText());
		if (question.getText().contains("#attack"))
		{
				return "@JeremsBoot #attack #ténèbres! /cc " + "@" + question.getScreenName();
		}
		return null;
    }
	

}
