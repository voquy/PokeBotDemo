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
		boolean pokeBall = Pattern.matches(".*po*ke*ba*ll*.*", texte);
		if (pokeBall) {

			if (PokeBot.getOwner() == null) {
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
							"#pokebattle - #pokemon - Owner: @" + PokeBot.getOwner()
							+ " #Level: "+ PokeBot.getLevel());
					
					//Tweet Pokeball sans #PokeBattle
					String tweetPkb ="@" + PokeBot.getOwner() + " You Are My Owner!";
					
					//Tweet Pokeball avec #PokeBattle
					String tweetPkbPB ="@" + PokeBot.getOwner() + " You Are My Owner!" + " #PokeBattle";
					
					//Si le tweet fait moins de 140 caractères
					if(tweetPkbPB.length() <= maxCarac) {
						return tweetPkbPB; 
					}
					return tweetPkb;
					
				} catch (TwitterException e)
				{
					e.printStackTrace();
				}
			}
				
			else if (PokeBot.getOwner().equals(question.getScreenName()))
			{
				//Tweet Pkmn déjà own par le dresseur sans #PokeBattle
				String tweetPkbByOwn ="@" +PokeBot.getOwner() + 
						" You Are Already My Owner Bitch!";
			
				//Tweet Pkmn déjà own par le dresseur avec #PokeBattle
				String tweetPkbByOwnPB ="@" +PokeBot.getOwner() + 
						" You Are Already My Owner Bitch!" + " #PokeBattle";
				
				//Si le tweet fait moins de 140 caractères
				if(tweetPkbByOwnPB.length() <= maxCarac){
					return tweetPkbByOwnPB;
				}
				return tweetPkbByOwn;
			}
			
			else
			{
				//Tweet Pkmn own par le dresseur sans #PokeBattle
				String tweetPOwn ="@"+question.getScreenName()+" @" + PokeBot.getOwner() + " is My Owner";
			
				//Tweet Pkmn own par le dresseur avec #PokeBattle
				String tweetPOwnPB ="@"+question.getScreenName()+" @" + PokeBot.getOwner() + " is My Owner" + " #PokeBattle";
				
				//Si le tweet fait moins de 140 caractères
				if(tweetPOwnPB.length() <= maxCarac){
					return tweetPOwnPB;
				}
				return tweetPOwn;
				
			}
		}

		return null;
	}
	
	
    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}
