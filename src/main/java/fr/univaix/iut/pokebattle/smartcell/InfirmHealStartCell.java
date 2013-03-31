package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.InfirmiereBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class InfirmHealStartCell implements SmartCell{
	
	public String ask(Tweet question) {
		if (question.getText().toLowerCase().contains("pokecenter") && InfirmiereBot.CCPkm == true)
		{
			// Suspension temps en millisecondes
			System.out.println("Soin du pokemon " + InfirmiereBot.pkmSoin + " en cours...");
			try {
				Thread.sleep(InfirmiereBot.tempsNecessaire * 60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InfirmiereBot.setCCPkm(false);
			PokeBot.setPVRestant(PokeBot.getPVTotal());
			return "@" + InfirmiereBot.drsPkmSoin + " @" + InfirmiereBot.pkmSoin + " is restored to full health";
		}
		return null;
	}
	

}
