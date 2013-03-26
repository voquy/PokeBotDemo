package fr.univaix.iut.pokebattle.smartcell;


import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    /*
    @Test
    public void testSalut() {
        assertEquals("@dresseur fannntooomiiinuuus",
        		cell.ask(new Tweet("dresseur","Salut!", null)));
    }
    */

    @Test
    public void testNotSalut() {
        //assertEquals("@dresseur fannntooomiiinuuus", cell.ask(new Tweet("dresseur","au revoir")));
    }

}
