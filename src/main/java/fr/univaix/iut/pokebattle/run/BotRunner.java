package fr.univaix.iut.pokebattle.run;

import java.io.IOException;
import java.io.InputStream;

import com.twitter.hbc.httpclient.ControlStreamException;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.twitter.TwitterBot;


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
    }

    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}




/*
public class BotRunner {

    static public void runBot(Bot bot, String credentialsFileName,
    							String key, String secret,
    							String token, String tokenSecret) {
        try {
            InputStream inputStream = getResourceAsStream(credentialsFileName);
            Credentials credentials = Credentials.loadCredentials(inputStream);
            credentials.setConsumerKey(key);
            credentials.setConsumerSecret(secret);
            credentials.setToken(token);
            credentials.setTokenSecret(tokenSecret);
            TwitterBot twitterBot = new TwitterBot(bot, credentials);
            twitterBot.startBot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ControlStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}
*/