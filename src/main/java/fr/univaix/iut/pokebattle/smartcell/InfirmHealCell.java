package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.InfirmiereBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class InfirmHealCell implements SmartCell{
	static final int maxCarac = 140;
	
	public String ask(Tweet question) {
		
		if (question.getText().toLowerCase().contains("heal"))
		{
			InfirmiereBot.setPkmSoin(question.getText().split("@")[2]);
			
			//Tweet question pv sans #PokeBattle
			String TweetPV = "@" + InfirmiereBot.getPkmSoin() + " #stat #pv ?";
			
			//Tweet question pv avec #PokeBattle
			String TweetPVPB = "@" + InfirmiereBot.getPkmSoin() + " #stat #pv ?" + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetPVPB.length() <= maxCarac) 
				return TweetPVPB;
			else
				return TweetPV;
		}
		
		if (question.getText().toLowerCase().contains("pv"))
		{
			// Il faudrait utiliser la persistence ici !!!!!!!!!!!!
			/*
			String text1 = question.getText().split("=")[1];
			String text2 = text1.split("/")[0];
			String text3 = text1.split("/")[1];
			int vieRest = Integer.parseInt(text2);
			int vieTot = Integer.parseInt(text3);
			int vieARecup = vieTot - vieRest;
			// Temps Necessaire en minutes
			*/
			int vieARecup = PokeBot.getPvTotal() - PokeBot.getPvRestant();
			InfirmiereBot.setTempsNecessaire(vieARecup/10);
			InfirmiereBot.setCCPkm(true);
			InfirmiereBot.setDrsPkmSoin("pkmOwner");
	
			//Tweet infirmière heal sans #PokeBattle
			String TweetIH = "@" + question.getScreenName() + " come in the #pokecenter /cc "
					+ "@" + InfirmiereBot.getPkmSoin();
			
			//Tweet infirmière heal avec #PokeBattle
			String TweetIHPB = "@" + question.getScreenName() + " come in the #pokecenter /cc "
					+ "@" + InfirmiereBot.getPkmSoin() + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetIHPB.length() <= maxCarac) 
				return TweetIHPB;
			return TweetIH;
		}
		return null;
    }
}
