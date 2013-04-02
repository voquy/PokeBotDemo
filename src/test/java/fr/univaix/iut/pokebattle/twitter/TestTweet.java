package fr.univaix.iut.pokebattle.twitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTweet {
    @Test
    public void testCreateTweet() {
        Tweet tweet = new Tweet("nedseb", "coucou !", null);
        assertEquals("nedseb", tweet.getScreenName());
        assertEquals("coucou !", tweet.getText());

        Tweet tweet2 = new Tweet("coucou !");
        assertEquals(null, tweet2.getScreenName());
        assertEquals("coucou !", tweet2.getText());

        
    }


}
