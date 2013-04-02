package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCellTest {
	PokemonCaracCell cell = new PokemonCaracCell();

    @Test
    public void testCarac1() {
        assertEquals("@jeremsboot #level=1",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #stat #level ?",null)));
    }
    
    @Test
    public void testCarac2() {
        assertEquals("@jeremsboot #xp=0",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #stat #xp ?",null)));
    }
    
    @Test
    public void testCarac3() {
        assertEquals("@jeremsboot #pv=80/100",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #stat #pv ?",null)));
    }
    
    @Test
    public void testCarac4() {
        assertEquals("@jeremsboot #tenebres #pp=10/35",
        		cell.ask(new Tweet("jeremsboot","@fantomiinus #statAttack #pp #tenebres ?",null)));
    }
    
}


