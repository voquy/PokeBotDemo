package fr.univaix.iut.pokebattle;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonPokeballCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;
import pokebattle.functions.PokemonPerdVie;


public class PokeBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */
	public static String owner = null;
	public static int vie = 100;
	
	final SmartCell[] smartCells = new SmartCell[]{
            new PokemonOwnerCell(),
            new PokemonPokeballCell(),
            new PokemonPerdVie(),
            new PokemonAttackCell(),
            new PokemonCriesCell()
            
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

	public static int getVie() {
		return vie;
	}

	
	public static void setVie(int vie) {
		PokeBot.vie = vie;
	}
}
