package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.smartcell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonAttackCellTest {

    PokemonAttackCell cell = new PokemonAttackCell();

    @Test
    public void testAttack1() {
        //assertEquals("@pikachu #attack #ténèbres! /cc @dresseur",
        		//cell.ask(new Tweet("dresseur","#attack #ténèbres @pikachu",null)));
    }
    @Test
    public void testAttack() {
        //assertEquals("@pikachu #attack #ténèbres! /cc @JeremsBoot @dresseur",
        	//	cell.ask(new Tweet("dresseur","@fantomiinus #attack #ténèbres @pikachu /cc @JeremsBoot", null)));
    }
}
