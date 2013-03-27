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
    
    @Test
    public void testAttack2() {
        assertEquals("@jeremsboot o_O ? /cc @pcreux @viviane @bulbizare1",
        	cell.ask(new Tweet("jeremsboot","@pikachuNyanNian #attack #grumpycat @bulbizare1 /cc @pcreux @viviane", null)));
    }
    
    @Test
    public void testAttack3() {
        assertEquals("@pikachuNyanNian #attack #charge /cc @nedseb @jeremsboot @viviane",
        	cell.ask(new Tweet("jeremsboot","@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane", null)));
    }
}
