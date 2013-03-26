package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.smartcell.PokemonPokeballCell;

public class PokemonPokeballCellTest {

	PokemonPokeballCell cell = new PokemonPokeballCell();
	
    @Test
    public void testPokeball() {
    	PokeBot.owner = null;
    //	assertEquals("@dresseur1 @dresseur is My Owner", cell.ask(new Tweet("dresseur1","Pokeball !")));    
    }
    

}
