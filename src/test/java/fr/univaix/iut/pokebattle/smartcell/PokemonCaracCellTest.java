package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;
import fr.univaix.iut.pokebattle.bot.PokeBot;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCellTest {
	PokemonCaracCell cell = new PokemonCaracCell();

    @Test
    public void testCarac1() {
        assertEquals("@jeremsboot #level=1 #PokeBattle",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #stat #level ?",null)));
    }
    
    @Test
    public void testCarac2() {
        assertEquals("@jeremsboot #xp=0 #PokeBattle",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #stat #xp ?",null)));
    }
    
    @Test
    public void testCarac3() {
        assertEquals("@jeremsboot #pv=10/100 #PokeBattle",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #stat #pv ?",null)));
    }
    
    @Test
    public void testCarac4() {
        assertEquals("@jeremsboot #tenebres #pp=10/35 #PokeBattle",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #statAttack #pp #tenebres ?",null)));
    }
    
    
    @Test
    public void testPVRestantsupPVTotal() {
    	PokeBot.setPvRestant(150);
    }
    
    @Test
    public void testReturnNull() {
        assertEquals(null,
        	cell.ask(new Tweet("quynhchee","@Fantomiinus sdklgjdkl", null)));
    }
    
    @Test
    public void testReturnNull2() {
        assertEquals(null,
        	cell.ask(new Tweet("jenesaispasqui","@Fantomiinus sdklgjdkl", null)));
    }
    
}


