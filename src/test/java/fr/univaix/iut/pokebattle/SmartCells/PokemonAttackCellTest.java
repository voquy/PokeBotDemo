package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonAttackCellTest {

    PokemonAttackCell cell = new PokemonAttackCell();

    /*@Test
    public void testAttack() {
        assertEquals("@pikachu #attack #ténèbres! /cc @dresseur", cell.ask(new Tweet("dresseur","#attack #ténèbres @pikachu")));
    }*/
    @Test
    public void testAttack() {
        assertEquals("@pikachu #attack #ténèbres! /cc @JeremsBoot @dresseur", cell.ask(new Tweet("dresseur","@fantomiinus #attack #ténèbres @pikachu /cc @JeremsBoot")));
    }
}
