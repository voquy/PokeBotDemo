package fr.univaix.iut.pokebattle.run;

import java.io.IOException;
import java.io.InputStream;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.twitter.hbc.httpclient.ControlStreamException;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.twitter.TwitterBot;
import fr.univaix.iut.pokebattle.twitter.TwitterBuilder;


public class BotRunner {
    static public void runBot(Bot bot, String credentialsFileName) {
        try {
            InputStream inputStream = getResourceAsStream(credentialsFileName);
            Credentials credentials = Credentials.loadCredentials(inputStream);
            TwitterBot twitterBot = new TwitterBot(bot, credentials);
            twitterBot.startBot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ControlStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
					"#pokebattle - #pokemon - #Etat: Sauvage - #Level: "+ PokeBot.level);
			
		}
		catch (TwitterException e) {
			e.printStackTrace();
		}
	
    }

    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}