package fr.univaix.iut.pokebattle.bot;


import fr.univaix.iut.pokebattle.smartcell.InfirmHealCell;
import fr.univaix.iut.pokebattle.smartcell.InfirmHealStartCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class InfirmiereBot implements Bot {
	
	private static String drsPkmSoin = null;
	private static String pkmSoin = null;
	private static boolean CCPkm = false;
	private static int tempsNecessaire = 0;
	
	public static String getDrsPkmSoin() {
		return drsPkmSoin;
	}

	public static void setDrsPkmSoin(String drsPkmSoin) {
		InfirmiereBot.drsPkmSoin = drsPkmSoin;
	}

	public static String getPkmSoin() {
		return pkmSoin;
	}

	public static void setPkmSoin(String pkmSoin) {
		InfirmiereBot.pkmSoin = pkmSoin;
	}

	public static boolean isCCPkm() {
		return CCPkm;
	}

	public static void setCCPkm(boolean cCPkm) {
		CCPkm = cCPkm;
	}

	public static int getTempsNecessaire() {
		return tempsNecessaire;
	}

	public static void setTempsNecessaire(int tempsNecessaire) {
		InfirmiereBot.tempsNecessaire = tempsNecessaire;
	}
	
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */

	final SmartCell[] smartCells = new SmartCell[]{
			new InfirmHealCell(),
			new InfirmHealStartCell()
            
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
