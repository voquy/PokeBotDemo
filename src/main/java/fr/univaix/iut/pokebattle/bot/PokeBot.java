package fr.univaix.iut.pokebattle.bot;

import java.util.Date;

import pokebattle.functions.PokemonPerdVie;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCCenterCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCaracCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonKoCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonPokeballCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
	
	private static String owner = null;
	private static int level = 1;
	private static int exp = 0;
	private static int pvRestant = 10;
	private static int pvRestantLast = 20;
	private static int pvTotal = 100;
	private static int ppRestant = 10;
	private static int ppTotal = 35;
	private static Date lastAttack = new Date();
	
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */


	final SmartCell[] smartCells = new SmartCell[]{
			new PokemonCCenterCell(),
            new PokemonOwnerCell(),
            new PokemonPokeballCell(),
            new PokemonKoCell(),
            new PokemonPerdVie(),
            new PokemonAttackCell(),
            new PokemonCaracCell(),
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
    
	private static String vraiNom = "Bulbizarre";
	public static String getVraiNom() {
		return vraiNom;
	}

	public static void setVraiNom(String vraiNom) {
		PokeBot.vraiNom = vraiNom;
	}

	public static String getOwner() {
		return owner;
	}

	public static void setOwner(String owner) {
		PokeBot.owner = owner;
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		PokeBot.level = level;
	}

	public static int getExp() {
		return exp;
	}

	public static void setExp(int exp) {
		PokeBot.exp = exp;
	}

	public static int getPvRestant() {
		return pvRestant;
	}

	public static void setPvRestant(int pvRestant) {
		PokeBot.pvRestant = pvRestant;
	}

	public static int getPvRestantLast() {
		return pvRestantLast;
	}

	public static void setPvRestantLast(int pvRestantLast) {
		PokeBot.pvRestantLast = pvRestantLast;
	}

	public static int getPvTotal() {
		return pvTotal;
	}

	public static void setPvTotal(int pvTotal) {
		PokeBot.pvTotal = pvTotal;
	}

	public static int getPpRestant() {
		return ppRestant;
	}

	public static void setPpRestant(int ppRestant) {
		PokeBot.ppRestant = ppRestant;
	}

	public static int getPpTotal() {
		return ppTotal;
	}

	public static void setPpTotal(int ppTotal) {
		PokeBot.ppTotal = ppTotal;
	}

	public static Date getLastAttack() {
		return lastAttack;
	}

	public static void setLastAttack(Date lastAttack) {
		PokeBot.lastAttack = lastAttack;
	}

	
}
