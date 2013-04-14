package fr.univaix.iut.pokebattle.bot;

/*
import com.google.common.collect.Lists;
import java.util.List;
*/

import fr.univaix.iut.pokebattle.smartcell.JudgeCombatCell;
//import fr.univaix.iut.pokebattle.smartcell.JudgeMonTestCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


import pokebattle.functions.JugeInitialiseFight;


public class JudgeBot implements Bot {
	
	private static String adversaire1;
	private static String adversaire2;
	private static String pokemonDress1;
	private static String pokemonDress2;
	private static int NumRound = 0;
	
	public static String getAdversaire1() {
		return adversaire1;
	}

	public static void setAdversaire1(String adversaire1) {
		JudgeBot.adversaire1 = adversaire1;
	}

	public static String getAdversaire2() {
		return adversaire2;
	}

	public static void setAdversaire2(String adversaire2) {
		JudgeBot.adversaire2 = adversaire2;
	}

	public static String getPokemonDress1() {
		return pokemonDress1;
	}

	public static void setPokemonDress1(String pokemonDress1) {
		JudgeBot.pokemonDress1 = pokemonDress1;
	}

	public static String getPokemonDress2() {
		return pokemonDress2;
	}

	public static void setPokemonDress2(String pokemonDress2) {
		JudgeBot.pokemonDress2 = pokemonDress2;
	}

	public static int getNumRound() {
		return NumRound;
	}

	public static void setNumRound(int numRound) {
		NumRound = numRound;
	}

	
	
	
	
	
	/**
     * List of smartcell the questions go through to
     * find an answer.
     */
    // final List<SmartCell> smartCells = Lists.newArrayList();

	final SmartCell[] smartCells = new SmartCell[]{
			new JugeInitialiseFight(),
            new JudgeCombatCell(),
            //new JudgeMonTestCell()
    };
	
    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     */
    @Override
    public String ask(Tweet question) {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}
