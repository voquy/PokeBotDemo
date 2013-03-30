package pokebattle.functions;

import java.util.Date;

/**
 * Reply to all.
 */
public class PokemonTempsInactif {
	
	public static long run(Date lastAttackPkm) {
		Date dateNow = new Date();
		long diff = dateNow.getTime() - lastAttackPkm.getTime();
		// Temps retourné en secondes
		return (diff / 1000);
	}

}
