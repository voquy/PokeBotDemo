package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.PokeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonPokeballCell implements SmartCell {

	public String ask(Tweet question) {

		if (question.getText().contains("Pokeball !")) {
			System.out.println(PokeBot.owner);
			if (PokeBot.owner == null) {
				PokeBot.owner = question.getScreenName();
				System.out.println(PokeBot.owner);
				return "@" + PokeBot.owner + " is My Owner";
			}
			return "@"+question.getScreenName()+" @" + PokeBot.owner + " is My Owner";


		}
		return null;
	}

}
