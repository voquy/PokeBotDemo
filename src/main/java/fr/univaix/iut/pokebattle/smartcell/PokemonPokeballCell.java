package fr.univaix.iut.pokebattle.smartcell;


import java.io.IOException;
import java.io.InputStream;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.run.PokemonMain;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.twitter.TwitterBuilder;


public class PokemonPokeballCell implements SmartCell {

	public String ask(Tweet question) {
		
		if (question.getText().toLowerCase().contains("pokeball")) {
			System.out.println(PokeBot.getOwner());

			if (PokeBot.owner == null) {
				PokeBot.setOwner(question.getScreenName());
				System.out.println(PokeBot.getOwner());
				
				InputStream inputStream = getResourceAsStream("PkmFantominus.properties");
	            Credentials credentials = new Credentials();
	            
				try {
					credentials = Credentials.loadCredentials(inputStream);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TwitterBuilder builder = new TwitterBuilder(credentials);
	            Twitter twitter = builder.build();
	            
				try {
					twitter.updateProfile(null, null, null,
							"#pokebattle - #pokemon - Owner: @" + PokeBot.owner);
					return "@" + PokeBot.owner + " You Are My Owner";
					
				} catch (TwitterException e) {
					e.printStackTrace();
				  }
			
		}
			return "@"+question.getScreenName()+" @" + PokeBot.getOwner() + " is My Owner";
	}
return null;

}
	
    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}
