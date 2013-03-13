package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;

public class PokemonOwnerCellTest {

	PokemonOwnerCell cell = new PokemonOwnerCell();

    @Test
    public void testNoOwner() {
        assertEquals("@dresseur No Owner", cell.ask(new Tweet("dresseur", "Owner ?")));
    }

}
