package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
    	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
    	Date date = new Date();
        assertEquals("@dresseur fannntooomiiinuuus " + dateFormat.format(date) + " #PokeBattle",
        		cell.ask(new Tweet("dresseur","coucou mon petit fanto", date)));
    }

    @Test
    public void testAurevoir() {
    	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
    	Date date = new Date();
        assertEquals("@dresseur fannntooomiiinuuus " + dateFormat.format(date) + " #PokeBattle",
        		cell.ask(new Tweet("dresseur","au revoir", date)));
    }

}
