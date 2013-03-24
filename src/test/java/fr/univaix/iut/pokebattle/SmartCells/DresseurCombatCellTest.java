package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.DresseurCombatCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DresseurCombatCellTest {

    DresseurCombatCell cell = new DresseurCombatCell();

    @Test
    public void testAttack() {
        assertEquals("@dresseur #fight #ok with @monPokemon /cc @jugecordier",
        	cell.ask(new Tweet("dresseur","@pierrebpalette #fight with @Fantomiinus /cc @jugecordier")));
    }
}
