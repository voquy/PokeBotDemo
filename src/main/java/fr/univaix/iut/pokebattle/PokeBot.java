package fr.univaix.iut.pokebattle;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonPokeballCell;


public class PokeBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */
    final SmartCell[] smartCells = new SmartCell[]{
            new PokemonOwnerCell(),
            new PokemonPokeballCell(),
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

}
