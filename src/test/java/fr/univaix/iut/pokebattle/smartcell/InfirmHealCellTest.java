package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.smartcell.InfirmHealCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InfirmHealCellTest {

    InfirmHealCell cell = new InfirmHealCell();

    @Test
    public void testHeal() {
        assertEquals("@bulbizare1 #stat #pv ?",
        	cell.ask(new Tweet("pcreux","@JoelleBourgPalet #heal @bulbizare1", null)));
    }
    
    @Test
    public void testGoCentrePkm() {
        assertEquals("@bulbizare1 come in the #pokecenter /cc @pkmOwner",
        	cell.ask(new Tweet("bulbizare1","@JoelleBourgPalet #PV=20/100", null)));
    }
    
    @Test
    public void testReturnNull() {
        assertEquals(null,
        	cell.ask(new Tweet("bulbizare1","@JoelleBourgPalet sdklgjdkl", null)));
    }
    
}
