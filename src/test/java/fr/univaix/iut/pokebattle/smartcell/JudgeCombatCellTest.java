package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JudgeCombatCellTest {

    JudgeCombatCell cell = new JudgeCombatCell();

    @Test
    public void testRound() {
    	JudgeBot.setAdversaire1("jeremsboot");
    	JudgeBot.setPokemonDress1("@pikachuNyanNian");
    	JudgeBot.setAdversaire2("quynhchee");
    	JudgeBot.setPokemonDress2("@fantomiinus");
    	JudgeBot.setNumRound(1);
        assertEquals("@pikachuNyanNian -10pv /cc @jeremsboot"
        		+ ";;Round #2 /cc @quynhchee @fantomiinus @jeremsboot @pikachuNyanNian",
        	cell.ask(new Tweet("fantomiinus",
        		"@pikachuNyanNian #attack #charge /cc @jeremsboot @quynhchee @judgecordier", null)));
        
    }
    

}



