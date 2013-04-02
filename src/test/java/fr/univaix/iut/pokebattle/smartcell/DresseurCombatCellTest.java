package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurCombatCellTest {

    DresseurCombatCell cell = new DresseurCombatCell();

    @Test
    public void testAttack() {
        assertEquals("@dresseur #fight #ok with @monPokemon /cc @jugecordier",
        	cell.ask(new Tweet("dresseur","@pierrebpalette #fight with @Fantomiinus /cc @jugecordier", null)));
    }
}
