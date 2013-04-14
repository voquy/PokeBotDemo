package pokebattle.pokedex.json;

import static org.junit.Assert.*;

import org.junit.Test;

import pokebattle.functions.PokemonAttackValide;

public class PokemonAttackValideTest {

    @Test
    public void testAttackValide() {
    	assertEquals(true, PokemonAttackValide.run("carapuce", "charge", 5));
    }
    
    @Test
    public void testAttackNonValide() {
    	assertEquals(false, PokemonAttackValide.run("carapuce", "hakunamatata", 5));
    }
    
}
