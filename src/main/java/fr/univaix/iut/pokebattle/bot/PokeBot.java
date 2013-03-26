package fr.univaix.iut.pokebattle.bot;

import pokebattle.functions.PokemonPerdVie;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonKoCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonPokeballCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
	public static String owner = null;
	public static int vie = 20;
	
	final SmartCell[] smartCells = new SmartCell[]{
            new PokemonOwnerCell(),
            new PokemonPokeballCell(),
            new PokemonKoCell(),
            new PokemonPerdVie(),
            new PokemonAttackCell(),
            new PokemonCriesCell()
            
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

	public static int getVie() {
		return vie;
	}

	
	public static void setVie(int vie) {
		PokeBot.vie = vie;
	}
}
