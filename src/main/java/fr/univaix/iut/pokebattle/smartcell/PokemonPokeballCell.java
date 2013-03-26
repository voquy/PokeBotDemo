package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class PokemonPokeballCell implements SmartCell {

	public String ask(Tweet question) {

		//String Owner = PokeBot.owner;
		
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
							"#pokebattle - #pokemon - Owner: " + PokeBot.owner);
					
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				return "@"+question.getScreenName()+" @" + PokeBot.owner + " is My Owner";
			}


		}
		return null;
	}

}
