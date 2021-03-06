package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonAttackCellTest {

    PokemonAttackCell cell = new PokemonAttackCell();

    
    @Test
    public void testAttack() {
        assertEquals(null,
        	cell.ask(new Tweet("dresseur","@fantomiinus #attack #ténèbres @pikachu /cc @JeremsBoot", null)));
    }
    
    
    @Test
    public void testAttack2() {
        assertEquals("@jeremsboot o_O ? /cc @pcreux @viviane @bulbizare1 #PokeBattle",
        	cell.ask(new Tweet("jeremsboot","@pikachuNyanNian #attack #grumpycat @bulbizare1 /cc @pcreux @viviane", null)));
    }

    
    @Test
    public void testAttack3() {
    	JudgeBot.setNumRound(1);
        assertEquals("@pikachuNyanNian #attack #charge /cc @nedseb @jeremsboot @viviane #1 #PokeBattle",
        	cell.ask(new Tweet("jeremsboot","@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane", null)));
    }


    @Test
    public void testReturnNull() {
        assertEquals(null,
        	cell.ask(new Tweet("bulbizare1","@Fantomiinus sdklgjdkl", null)));
    }
    

}

    
