package pokebattle.functions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokebattle.functions.JugeInitialiseFight;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JugeInitialiseFightTest {

	JugeInitialiseFight cell = new JugeInitialiseFight();
	
    @Test
    public void testRound1() {
    	JudgeBot.setAdversaire1("jeremsboot");
    	JudgeBot.setPokemonDress1("@pikachuNyanNian");
        assertEquals("Round #1 /cc @jeremsboot @pikachuNyanNian @dresseur @bulbizare1",
        	cell.ask(new Tweet("dresseur","@jeremsboot #fight #ok with @bulbizare1 /cc @jugecordier", null)));
        
    }
}


