package fr.univaix.iut.pokebattle.twitter;

import java.io.IOException;

import twitter4j.Twitter;

import com.twitter.hbc.httpclient.ControlStreamException;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;

public class TwitterBot {
    TwitterUserStreamEasy twitterUserStreamEasy;
    Twitter twitter;

    public TwitterBot(final Bot bot, Credentials credentials) {
        this.twitter = new TwitterBuilder(credentials).build();
        this.twitterUserStreamEasy = new TwitterUserStreamEasyBuilder(twitter, bot).build(credentials);
    }

    public void startBot() throws InterruptedException, ControlStreamException, IOException {
        twitterUserStreamEasy.oauth();
    }

}
