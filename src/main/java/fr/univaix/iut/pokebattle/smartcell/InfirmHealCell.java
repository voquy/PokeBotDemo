package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.InfirmiereBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class InfirmHealCell implements SmartCell{

	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (question.getText().toLowerCase().contains("heal"))
		{
			InfirmiereBot.pkmSoin = question.getText().split("@")[2];
			
			//Tweet question pv sans #PokeBattle
			String TweetPV = "@" + InfirmiereBot.pkmSoin + " #stat #pv ?";
			
			//Tweet question pv avec #PokeBattle
			String TweetPVPB = "@" + InfirmiereBot.pkmSoin + " #stat #pv ?" + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetPVPB.length() <= 140) 
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
			int vieARecup = PokeBot.pvTotal - PokeBot.pvRestant;
			InfirmiereBot.tempsNecessaire = vieARecup/10;
			InfirmiereBot.CCPkm = true;
			InfirmiereBot.drsPkmSoin = "pkmOwner";
	
			//Tweet infirmière heal sans #PokeBattle
			String TweetIH = "@" + question.getScreenName() + " come in the #pokecenter /cc "
					+ "@" + InfirmiereBot.drsPkmSoin;
			
			//Tweet infirmière heal avec #PokeBattle
			String TweetIHPB = "@" + question.getScreenName() + " come in the #pokecenter /cc "
					+ "@" + InfirmiereBot.drsPkmSoin + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetIHPB.length() <= 140) 
				return TweetIHPB;
			else
				return TweetIH;
		}
		return null;
    }
}
