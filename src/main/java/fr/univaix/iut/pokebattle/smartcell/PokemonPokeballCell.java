package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class PokemonPokeballCell implements SmartCell {

	public String ask(Tweet question) {
		
		if (question.getText().toLowerCase().contains("pokeball")) {
			System.out.println(PokeBot.getOwner());
			if (PokeBot.owner == null) {
				PokeBot.setOwner(question.getScreenName());
				System.out.println(PokeBot.getOwner());
				
				Twitter twitter = TwitterFactory.getSingleton();
				try {
					twitter.updateProfile(null, null, null,
							"#pokebattle - #pokemon - Owner: " + PokeBot.owner);
					return "@" + PokeBot.owner + " is My Owner";
					
				} catch (TwitterException e) {
					e.printStackTrace();
				}

			}
			else
			{
				Twitter twitter = TwitterFactory.getSingleton();

				try {
					twitter.updateProfile(null, null, null,
						"#pokebattle - #pokemon - Owner: " + PokeBot.owner);
					return "@"+question.getScreenName()+" @" + PokeBot.owner + " is My Owner";
				} catch (TwitterException e) {
					e.printStackTrace();
				}
			}


		}
		return null;
	}

}
