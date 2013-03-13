package fr.univaix.iut.pokebattle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTweet {
    @Test
    public void testCreateTweet() {
        Tweet tweet = new Tweet("nedseb", "coucou !");
        assertEquals("nedseb", tweet.getScreenName());
        assertEquals("coucou !", tweet.getText());

        Tweet tweet2 = new Tweet("coucou !");
        assertEquals(null, tweet2.getScreenName());
        assertEquals("coucou !", tweet2.getText());

        
    }


}
