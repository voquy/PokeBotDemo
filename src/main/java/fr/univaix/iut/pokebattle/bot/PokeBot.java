package fr.univaix.iut.pokebattle.bot;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import pokebattle.functions.PokemonPerdVie;
import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
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
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
    static EntityManager em = emf.createEntityManager();
    static DAOPokemonJPA dao = new DAOPokemonJPA(em);
   public static Pokemon Poke = dao.getById("Fantomiinus");
    
	public static String owner = Poke.getOwner();
	public static int vie =  Poke.getBaseHP();
	

	public static String vraiNom = "Bulbizarre";

	public static int level = 1;
	public static int exp = 0;
	public static int pvRestant = 80;
	public static int pvRestantLast = 20;
	public static int pvTotal = 100;
	public static int ppRestant = 10;
	public static int ppTotal = 35;
	public static Date lastAttack = new Date();


	final SmartCell[] smartCells = new SmartCell[]{
		//	new PokemonCCenterCell(),
          //  new PokemonOwnerCell(),
          //  new PokemonPokeballCell(),
           new PokemonKoCell(),
            new PokemonPerdVie(),
            new PokemonAttackCell(),

           new PokemonCaracCell(),

           // new PokemonCriesCell()     
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
	
	
	public static String getVraiNom() {
		return vraiNom;
	}

	public static void setVraiNom(String vraiNom) {
		PokeBot.vraiNom = vraiNom;
	}

	
	public static int getLevel(){
		return level;
	}
	
	public static void setLevel(int Level){
		 PokeBot.level = Level;
	}
	
	public static int getEXP(){
		return exp;
	}
	
	public static void setEXP(int exp){
		 PokeBot.exp = exp;
	}
	
	public static int getPVRestant(){
		return pvRestant;
	}
	
	public static void setPVRestant(int PVRestant){
		 PokeBot.pvRestant= PVRestant;
	}
	
	public static int getPVRestantLast(){
		return pvRestantLast;
	}
	
	public static void setPVRestantLast(int PVRestantLast){
		 PokeBot.pvRestantLast = PVRestantLast;
	}
	
	public static int getPVTotal(){
		return pvTotal;
	}
	
	public static void setPVTotal(int PVTotal){
		 PokeBot.pvTotal = PVTotal;
	}
	
	public static int getPPTotal(){
		return ppTotal;
	}
	
	public static void setPPTotal(int PPTotal){
		 PokeBot.ppTotal = PPTotal;
	}
	
	
	public static Date getLastAttack() {
		return lastAttack;
	}

	public static void setLastAttack(Date lastAttack) {
		PokeBot.lastAttack = lastAttack;
	}
	
}
