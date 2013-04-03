package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.smartcell.DresseurCombatCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DresseurCombatCellTest {

    DresseurCombatCell cell = new DresseurCombatCell();

    @Test
    public void testAttack() {
        assertEquals("@dresseur #fight #ok with @monPokemon /cc @jugecordier",
        	cell.ask(new Tweet("dresseur","@pierrebpalette #fight with @Fantomiinus /cc @jugecordier", null)));
    }

    @Test
    public void testAttackRound() {
    	JudgeBot.setNumRound(1);
        assertEquals("@onix__ #attack #roche @pikachu /cc @jeremsboot @viviane #1",
        	cell.ask(new Tweet("pikachu",
        			"@onix__ #attack #charge /cc @quynhchee @jeremsboot @viviane #1", null)));
    }
    

}
