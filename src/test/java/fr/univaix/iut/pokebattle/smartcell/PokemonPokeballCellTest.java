package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonPokeballCellTest {

	PokemonPokeballCell cell = new PokemonPokeballCell();
	
    @Test
    public void testPokeballOwner() {
    	PokeBot.owner = "quynhchee";
    	assertEquals("@dresseur1 @quynhchee is My Owner #PokeBattle",
    			cell.ask(new Tweet("dresseur1","Pokeball !", null)));
    }
    
    @Test
    public void testPokeballSonProprePkm() {
    	PokeBot.owner = "quynhchee";
    	assertEquals("@quynhchee You Are Already My Owner Bitch! #PokeBattle",
    			cell.ask(new Tweet("quynhchee","Pokeball !", null)));
    }
    
    @Test
    public void testPokeballSonProprePkm_PB() {
    	String the_owner = "quynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhcheequynhchee";
    	PokeBot.owner = the_owner;
    	assertEquals("@" + the_owner + " You Are Already My Owner Bitch!",
    			cell.ask(new Tweet(the_owner,"Pokeball !", null)));
    }
    

}
