package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.smartcell.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCellTest {

	PokemonOwnerCell cell = new PokemonOwnerCell();

    @Test
    public void testOwner() {
    	PokeBot.setOwner("quynhchee");
        assertEquals("@quynhchee @quynhchee is My Owner!!!! #PokeBattle",
        	cell.ask(new Tweet("quynhchee", "Owner ?", null)));
    }
	
    @Test
    public void testNoOwner() {
    	PokeBot.setOwner(null);
        assertEquals("@dresseur No Owner #PokeBattle",
        	cell.ask(new Tweet("dresseur", "Owner ?", null)));
    }
    

}
