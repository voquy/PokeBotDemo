package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import pokebattle.functions.JudgeCalculExpWin;

import static org.junit.Assert.assertEquals;

public class JudgeCombatCellTest {

    JudgeCombatCell cell = new JudgeCombatCell();

    @Test
    public void testEmetteurKo() {
    	JudgeBot.setAdversaire1("jeremsboot");
    	JudgeBot.setPokemonDress1("@pikachuNyanNian");
    	JudgeBot.setAdversaire2("quynhchee");
    	JudgeBot.setPokemonDress2("@fantomiinus");
    	JudgeBot.setNumRound(1);
    	int expWin = JudgeCalculExpWin.calculExp(JudgeBot.getPokemonDress2(), JudgeBot.getPokemonDress1());
    	assertEquals(JudgeBot.getPokemonDress1() + " #Win +" + expWin + "xp" + " #PokeBattle",
        	cell.ask(new Tweet("fantomiinus",
        		"@#KO /cc @jugecordier @jeremsboot @quynhchee", null)));
    }
    
    @Test
    public void testRound() {
    	JudgeBot.setAdversaire1("jeremsboot");
    	JudgeBot.setPokemonDress1("@pikachuNyanNian");
    	JudgeBot.setAdversaire2("quynhchee");
    	JudgeBot.setPokemonDress2("@fantomiinus");
    	JudgeBot.setNumRound(1);
        assertEquals("@pikachuNyanNian -10pv /cc @jeremsboot #PokeBattle"
        		+ ";;Round #2 /cc @quynhchee @fantomiinus @jeremsboot @pikachuNyanNian #PokeBattle",
        	cell.ask(new Tweet("fantomiinus",
        		"@pikachuNyanNian #attack #charge /cc @jeremsboot @quynhchee @judgecordier", null)));
        
    }
    
    @Test
    public void testTailleTweet() {
    	JudgeBot.setAdversaire1("jeremsboot");
    	JudgeBot.setPokemonDress1("@pikachuNyanNianpikachuNyanNianpikachuNyanNian");
    	JudgeBot.setAdversaire2("quynhchee");
    	JudgeBot.setPokemonDress2("@fantomiinus");
    	JudgeBot.setNumRound(1);
        assertEquals(JudgeBot.getPokemonDress1() + " -10pv /cc @jeremsboot"
        		+ ";;Round #2 /cc @quynhchee @fantomiinus @jeremsboot " + JudgeBot.getPokemonDress1(),
        	cell.ask(new Tweet("fantomiinus",
        			JudgeBot.getPokemonDress1() + " #attack #charge /cc @jeremsboot @quynhchee @judgecordier", null)));
        
    }
    
    @Test
    public void testReturnNull() {
        assertEquals(null,
        	cell.ask(new Tweet("jenesaispasqui","@Fantomiinus sdklgjdkl", null)));
    }
    

}



