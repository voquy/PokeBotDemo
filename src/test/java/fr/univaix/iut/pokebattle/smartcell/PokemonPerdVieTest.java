package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import pokebattle.functions.PokemonPerdVie;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonPerdVieTest {

	PokemonPerdVie cell = new PokemonPerdVie();
	
	@Test
	public void testEmetteur() {
        assertEquals(null,
            	cell.ask(new Tweet("dresseur","tu perds de la vie", null)));
    }
	
	@Test
	public void testRéponse() {
		PokeBot.pvRestant = 10;
		String dresseur = "@unjourjeserailemeilleurdresseurjemebattraisansrépitjeferaitoutpouretrevainqueuretgagnerlesdéfis";
        assertEquals("#KO /cc @jugecordier @dresseurAdv " + dresseur,
            	cell.ask(new Tweet("jugecordier","@fantomiinus -10pv /cc " + dresseur, null)));
    }

}
