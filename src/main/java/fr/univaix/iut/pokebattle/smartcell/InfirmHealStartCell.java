package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.InfirmiereBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class InfirmHealStartCell implements SmartCell{
	static final int maxCarac = 140;
	
	public String ask(Tweet question) {
		if (question.getText().toLowerCase().contains("pokecenter") && InfirmiereBot.isCCPkm())
		{
			// Suspension temps en millisecondes
			System.out.println("Soin du pokemon " + InfirmiereBot.getPkmSoin() + " en cours...");
			try {
				Thread.sleep(InfirmiereBot.getTempsNecessaire() * 60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InfirmiereBot.setCCPkm(false);
			PokeBot.setPvRestant(PokeBot.getPvTotal());
			
			//Tweet heal start sans #PokeBattle
			String TweetHS = "@" + InfirmiereBot.getPkmSoin() + " @" + InfirmiereBot.getPkmSoin()
					+ " is restored to full health";
			
			//Tweet heal start avec #PokeBattle
			String TweetHSPB = "@" + InfirmiereBot.getDrsPkmSoin() + " @" + InfirmiereBot.getPkmSoin() 
					+ " is restored to full health" + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetHSPB.length() <= maxCarac) 
				return TweetHSPB;
			return TweetHS;
		}
		return null;
	}
	

}
