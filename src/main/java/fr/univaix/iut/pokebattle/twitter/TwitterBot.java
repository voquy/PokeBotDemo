package fr.univaix.iut.pokebattle.twitter;

import com.twitter.hbc.httpclient.ControlStreamException;
import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import fr.univaix.iut.pokebattle.tuse.UserStreamAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

public class TwitterBot {
    private final static Logger logger = LoggerFactory.getLogger(TwitterBot.class);

    Credentials credentials;
    TwitterUserStreamEasy twitterUserStreamEasy;
    Twitter twitter;

    public TwitterBot(final Bot bot, Credentials credentials) {
        this.credentials = credentials;
        this.twitter = buildTwitter(credentials);
        this.twitterUserStreamEasy = buildTwitterUserStreamEasy(bot);
    }

    private TwitterUserStreamEasy buildTwitterUserStreamEasy(final Bot bot) {
        UserStreamListener listener = new UserStreamAdapter() {
            @Override
            public void onStatus(Status status) {
                try {
                    logger.info("TwitterUserStreamEasyExample.onStatus()");
                    if (isTweetOfMe(status) || !isTweetForMe(status)) {
                        logger.info("Ignored status change");
                        return;
                    }

                    String response = bot.ask(new Tweet(status.getUser().getScreenName(), status.getText()));
                    if (response != null)
                        twitter.updateStatus(response);

                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        };

        return new TwitterUserStreamEasy(listener);
    }

    private Twitter buildTwitter(Credentials credentials) {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(credentials.getConsumerKey())
                .setOAuthConsumerSecret(credentials.getConsumerSecret())
                .setOAuthAccessToken(credentials.getToken())
                .setOAuthAccessTokenSecret(credentials.getTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    public void startBot() throws InterruptedException, ControlStreamException, IOException {
        twitter = TwitterFactory.getSingleton();
        twitterUserStreamEasy.oauth();
    }

    private boolean isTweetForMe(Status status) throws TwitterException {
        return status.getText().toLowerCase().contains(twitter.getScreenName().toLowerCase());
    }

    private boolean isTweetOfMe(Status status) throws TwitterException {
        return status.getUser().getId() == twitter.getId();
    }
}
