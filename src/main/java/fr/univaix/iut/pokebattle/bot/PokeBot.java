package fr.univaix.iut.pokebattle.bot;

import pokebattle.functions.PokemonPerdVie;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCaracCell;
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
	public static int Level= 1;
	public static int XP = 0;
	public static int PVRestant = 10;
	public static int PVTotal = 100;
	public static int PPRestant = 10;
	public static int PPTotal = 35;
	
	final SmartCell[] smartCells = new SmartCell[]{
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
    
	public static String getOwner() {
		return owner;
	}

	public static void setOwner(String owner) {
		PokeBot.owner = owner;
	}

	public static int getVie() {
		return vie;
	}

	
	public static void setVie(int vie) {
		PokeBot.vie = vie;
	}
	
	public static int getLevel(){
		return Level;
	}
	
	public static void setLevel(int Level){
		 PokeBot.Level = Level;
	}
	
	public static int getXP(){
		return XP;
	}
	
	public static void setXP(int XP){
		 PokeBot.XP = XP;
	}
	
	public static int getPVRestant(){
		return PVRestant;
	}
	
	public static void setPVRestant(int PVRestant){
		 PokeBot.PVRestant= PVRestant;
	}
	
	public static int gePVTotal(){
		return PVTotal;
	}
	
	public static void setPVTotal(int PVTotal){
		 PokeBot.PVTotal = PVTotal;
	}
	
	public static int getPPTotal(){
		return PPTotal;
	}
	
	public static void setPPTotal(int PPTotal){
		 PokeBot.PPTotal = PPTotal;
	}
	
	
}
