package fr.univaix.iut.pokebattle;


import pokebattle.functions.JugeInitialiseFight;
import fr.univaix.iut.pokebattle.smartcells.JugeCombatCell;

public class JugeBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */
	public static String adversaire1;
	public static String adversaire2;
	public static String pokemonDress1;
	public static String pokemonDress2;
	
	
	public static String getAdversaire1() {
		return adversaire1;
	}

	public static void setAdversaire1(String adversaire1) {
		JugeBot.adversaire1 = adversaire1;
	}

	public static String getAdversaire2() {
		return adversaire2;
	}

	public static void setAdversaire2(String adversaire2) {
		JugeBot.adversaire2 = adversaire2;
	}
	
	public static String getPokemonDress1() {
		return pokemonDress1;
	}

	public static void setPokemonDress1(String pokemonDress1) {
		JugeBot.pokemonDress1 = pokemonDress1;
	}

	public static String getPokemonDress2() {
		return pokemonDress2;
	}

	public static void setPokemonDress2(String pokemonDress2) {
		JugeBot.pokemonDress2 = pokemonDress2;
	}
	

	final SmartCell[] smartCells = new SmartCell[]{
			new JugeInitialiseFight(),
            new JugeCombatCell() 
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
