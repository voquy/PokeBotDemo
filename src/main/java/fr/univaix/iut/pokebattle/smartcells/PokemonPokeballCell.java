package fr.univaix.iut.pokebattle.smartcells;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.PokeBot;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonPokeballCell implements SmartCell {

	public String ask(Tweet question) {

		String Owner = PokeBot.owner;
		
		if (question.getText().contains("Pokeball !")) {
			System.out.println(PokeBot.owner);
			if (PokeBot.owner == null) {
				PokeBot.owner = question.getScreenName();
				System.out.println(PokeBot.owner);
				return "@" + PokeBot.owner + " is My Owner";
			}
			else
			{
				Twitter twitter = TwitterFactory.getSingleton();

				try {
					twitter.updateProfile(null, null, null,
							"#pokebattle - #pokemon - Owner: " + Owner);
					
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				return "@"+question.getScreenName()+" @" + PokeBot.owner + " is My Owner";
			}


		}
		return null;
	}

}
