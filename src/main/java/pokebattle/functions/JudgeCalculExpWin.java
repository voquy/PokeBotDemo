package pokebattle.functions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;


/**
 * Reply to all.
 */
public class JudgeCalculExpWin {

	public static double calculExp (String pkmGagnant, String pkmPerdant) {
		// Code en dur, besoin de la persitence
		/*
		 int expWin = expPkmPerdant * lvlPkmGagnant / 7;
		 return expWin;
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
	    EntityManager em = emf.createEntityManager();
	    
	    DAOPokemonJPA dao = new DAOPokemonJPA(em);
	    Pokemon pkWin = dao.getById("Fantomiinus");
	    Pokemon pkLoose = dao.getById("Evoli_iut");
	    double expWin = pkLoose.getExp() * pkWin.getLevel() / 7 ;
		return expWin;
	}

}