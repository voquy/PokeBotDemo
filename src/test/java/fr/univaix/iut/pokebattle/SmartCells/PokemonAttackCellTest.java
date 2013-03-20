package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonAttackCellTest {

    PokemonAttackCell cell = new PokemonAttackCell();

    @Test
    public void testAttack() {
        assertEquals("@JeremsBoot #attack #ténèbres! /cc @dresseur", cell.ask(new Tweet("dresseur","#attack #ténèbres @JeremsBoot")));
    }

}
