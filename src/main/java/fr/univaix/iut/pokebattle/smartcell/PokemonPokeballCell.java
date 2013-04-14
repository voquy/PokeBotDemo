package fr.univaix.iut.pokebattle.smartcell;


import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.run.PokemonMain;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.twitter.TwitterBuilder;


public class PokemonPokeballCell implements SmartCell {
	static final int maxCarac = 140;
	public String ask(Tweet question) {
		
		// texte à tester    
		String texte =  question.getText().toLowerCase();
		boolean Pkb = Pattern.matches(".*po*ke*ba*ll*.*", texte);
		if (Pkb) {

			if (PokeBot.owner == null) {
				PokeBot.setOwner(question.getScreenName());
				System.out.println(PokeBot.getOwner());
				
				InputStream inputStream = getResourceAsStream("PkmFantominus.properties");
	            Credentials credentials = new Credentials();
	            
				try {
					credentials = Credentials.loadCredentials(inputStream);
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TwitterBuilder builder = new TwitterBuilder(credentials);
	            Twitter twitter = builder.build();
	            
				try {
					twitter.updateProfile(null, null, null,
							"#pokebattle - #pokemon - Owner: @" + PokeBot.owner
							+ " #Level: "+ PokeBot.level);
					
					//Tweet Pokeball sans #PokeBattle
					String TweetP ="@" + PokeBot.owner + " You Are My Owner!";
					
					//Tweet Pokeball avec #PokeBattle
					String TweetPPB ="@" + PokeBot.owner + " You Are My Owner!" + " #PokeBattle";
					
					//Si le tweet fait moins de 140 caractères
					if(TweetPPB.length() <= maxCarac)
						return TweetPPB; 
					else
						return TweetP;
					
				} catch (TwitterException e)
				{
					e.printStackTrace();
				}
			}
				
			else if (PokeBot.getOwner().equals(question.getScreenName()))
			{
				//Tweet Pkmn déjà own par le dresseur sans #PokeBattle
				String TweetPAOwn ="@" +PokeBot.owner + 
						" You Are Already My Owner Bitch!";
			
				//Tweet Pkmn déjà own par le dresseur avec #PokeBattle
				String TweetPAOwnPB ="@" +PokeBot.owner + 
						" You Are Already My Owner Bitch!" + " #PokeBattle";
				
				//Si le tweet fait moins de 140 caractères
				if(TweetPAOwnPB.length() <= maxCarac)
					return TweetPAOwnPB;
				else
					return TweetPAOwn;
			}
			
			else
			{
				//Tweet Pkmn own par le dresseur sans #PokeBattle
				String TweetPOwn ="@"+question.getScreenName()+" @" + PokeBot.getOwner() + " is My Owner";
			
				//Tweet Pkmn own par le dresseur avec #PokeBattle
				String TweetPOwnPB ="@"+question.getScreenName()+" @" + PokeBot.getOwner() + " is My Owner" + " #PokeBattle";
				
				//Si le tweet fait moins de 140 caractères
				if(TweetPOwnPB.length() <= maxCarac)
					return TweetPOwnPB;
				else
					return TweetPOwn;
				
			}
		}

		return null;
	}
	
	
    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}
