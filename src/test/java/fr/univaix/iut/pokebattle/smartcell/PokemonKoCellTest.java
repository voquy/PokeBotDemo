package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonKoCellTest {

    PokemonKoCell cell = new PokemonKoCell();

    @Test
    public void testReturnKo() {
    	PokeBot.setPVRestant(0);
        assertEquals("#KO /cc @viviane @dresseurAdv @quynhchee #PokeBattle",
        	cell.ask(new Tweet("viviane","@fantomiinus -10pv /cc @quynhchee", null)));
    }
    
    @Test
    public void testReturnNull() {
    	PokeBot.setPVRestant(50);
        assertEquals(null,
        	cell.ask(new Tweet("quynhchee","", null)));
    }
}
