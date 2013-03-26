package fr.univaix.iut.pokebattle.bot;


import fr.univaix.iut.pokebattle.smartcell.DresseurCombatCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */

	final SmartCell[] smartCells = new SmartCell[]{
            new DresseurCombatCell() 
    };

    /**
     * Ask something to BoBot, it will respond to you.
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
