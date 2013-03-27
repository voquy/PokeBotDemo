package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using smartcell properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
//        assertEquals("Pika pika", pokeBot.ask(new Tweet("Salut")));
//        assertEquals("Pika pika", pokeBot.ask(new Tweet("This is not a question.")));
        //assertEquals("@nedseb Pika pika", pokeBot.ask(new Tweet("nedseb", "Salut")));
        //assertEquals("@nedseb Pika pika", pokeBot.ask(new Tweet("nedseb", "This is not a question.")));
    }
    
    @Test
    public void testOwner(){
    	// assertEquals("@dresseur No Owner", pokeBot.ask(new Tweet("dresseur","Owner ?")));
    	// assertEquals("@dresseur @owner is My Owner", pokeBot.ask(new Tweet("dresseur","Owner ?")));
    }
    

    @Test
    public void testPokeball(){
    	//assertEquals("@dresseur is My Owner", pokeBot.ask(new Tweet("dresseur","Pokeball !")));
    	//assertEquals("@dresseur @Dono is My Owner", pokeBot.ask(new Tweet("dresseur","Pokeball !")));
    }
    
}
