package fr.univaix.iut.pokebattle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using SmartCells properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
        assertEquals("@dresseur fannntooomiiinuuus", pokeBot.ask(new Tweet("dresseur","Salut")));
        assertEquals("@dresseur fannntooomiiinuuus", pokeBot.ask(new Tweet("dresseur", "This is not a question.")));
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
