package fr.univaix.iut.pokebattle;

import com.twitter.hbc.httpclient.ControlStreamException;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import fr.univaix.iut.pokebattle.tuse.UserStreamAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

public class TwitTestBot {
    private final static Logger logger = LoggerFactory.getLogger(TwitTestBot.class);
    private final String CONSUMER_KEY = "Hyf6Ayk4bAh8kAw4vy7A";
    private final String CONSUMER_SECRET = "KIr7NOtLfWSVFAxIwmqS7uBVe0P1th2hnTgvv1h1VE";
    private final String TOKEN = "1283208630-OgqhM2B6i7QexEFEPC0XcAdbjckXe5oLOREsYP7";
    private final String TOKENSECRET = "4BCEL3CwVTWWXpe0lL5gIXsmINFi9ev8NtkVwAE6eK8";
    public AccessToken ACCESSTOKEN = new AccessToken(TOKEN, TOKENSECRET); 

    TwitterUserStreamEasy twitterUserStreamEasy;
    Twitter twitter = new TwitterFactory().getInstance();

    public TwitTestBot(final Bot bot) {
    	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    	twitter.setOAuthAccessToken(ACCESSTOKEN);
    	
    	
    	/*
    	 ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(CONSUMER_KEY);
        builder.setOAuthConsumerSecret(CONSUMER_SECRET);
        builder.setOAuthAccessToken(TOKEN);
        builder.setOAuthAccessTokenSecret(TOKENSECRET);
        Configuration configuration = builder.build();
        TwitterFactory factory = new TwitterFactory(configuration);
        final Twitter twitter = factory.getInstance();
    	 */
    	
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

    public static void main(String[] args) {

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
