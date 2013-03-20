package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
        assertEquals("Pika pika", cell.ask(new Tweet("Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("Pika pika", cell.ask(new Tweet("au revoir")));
    }

}
