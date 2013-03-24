package fr.univaix.iut.pokebattle;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twitter.hbc.httpclient.ControlStreamException;

import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import fr.univaix.iut.pokebattle.tuse.UserStreamAdapter;
import twitter4j.*;
import twitter4j.auth.AccessToken;

public class Login {
	private Logger logger = null;
    private final static String CONSUMER_KEY = "Hyf6Ayk4bAh8kAw4vy7A";
    private final static String CONSUMER_KEY_SECRET = "KIr7NOtLfWSVFAxIwmqS7uBVe0P1th2hnTgvv1h1VE";
    
    TwitterUserStreamEasy twitterUserStreamEasy;
	Twitter twitter = new TwitterFactory().getInstance();
	 


    private String getSavedAccessTokenSecret() {
	 // consider this is method to get your previously saved Access Token
	 // Secret
	 return "4BCEL3CwVTWWXpe0lL5gIXsmINFi9ev8NtkVwAE6eK8";
    }

    private String getSavedAccessToken() {
	 // consider this is method to get your previously saved Access Token
	 return "1283208630-OgqhM2B6i7QexEFEPC0XcAdbjckXe5oLOREsYP7";
    }
    
    public Login (final Bot bot) throws TwitterException {
    
   	logger = LoggerFactory.getLogger(Login.class);
    
    twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
    	
   	 // here's the difference
   	 String accessToken = getSavedAccessToken();
   	 String accessTokenSecret = getSavedAccessTokenSecret();
   	 AccessToken oathAccessToken = new AccessToken(accessToken,
   	  accessTokenSecret);

   	 twitter.setOAuthAccessToken(oathAccessToken);
   	 // end of difference
   	
   	 twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");
   	
   	 System.out.println("\nMy Timeline:");

   	 // I'm reading your timeline
   	 ResponseList list = twitter.getHomeTimeline();
   	/* for (Status each : list) {
   	
   	     System.out.println("Sent by: @" + each.getUser().getScreenName()
   	      + " - " + each.getUser().getName() + "\n" + each.getText()
   	      + "\n");
   	 }*/
   	 
   	 
   	 
        UserStreamListener listener = new UserStreamAdapter() {


            @Override
            public void onStatus(Status status) {
                try {
                    logger.info("TwitterUserStreamEasyExample.onStatus()");
                    System.out.println(status.getText());
                    if (isTweetOfMe(status) || !isTweetForMe(status)) {
                        logger.info("Ignored status change");
                        return;
                    }

                    String response = bot.ask(new Tweet(status.getUser().getScreenName(), status.getText()));
                    if (response != null)
                        twitter.updateStatus(response);

                }
                
                catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        };

        twitterUserStreamEasy = new TwitterUserStreamEasy(listener);
    }

    public void startBot() throws InterruptedException, ControlStreamException, IOException {
        twitterUserStreamEasy.oauth();
    }

    // Faire attention à la casse
    private boolean isTweetForMe(Status status) throws TwitterException {
        return status.getText().toLowerCase().contains(twitter.getScreenName().toLowerCase());
    }

    private boolean isTweetOfMe(Status status) throws TwitterException {
        return status.getUser().getId() == twitter.getId();
    }
    

    public static void main(String[] args) throws Exception {

        try {
            TwitTestBot TwitTestBot = new TwitTestBot(new PokeBot());
            TwitTestBot.startBot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ControlStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}