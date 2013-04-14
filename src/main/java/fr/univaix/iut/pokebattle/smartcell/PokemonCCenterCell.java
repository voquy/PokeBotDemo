package fr.univaix.iut.pokebattle.smartcell;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCCenterCell implements SmartCell{
	static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	static final int maxCarac = 140;
	
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		if (emetteur.toLowerCase().equals("joellebpalette"))
		{
			if (question.getText().toLowerCase().contains("#pokecenter"))
			{	
				//Tweet pokecenter sans #PokeBattle
				String tweetPCenter = "@" + question.getScreenName() + " fannntooomiiinuuus #pokecenter"
						+ "   " + dateFormat.format(question.getDate());
				
				//Tweet pokecenter avec #PokeBattle
				String tweetPCenterPB = "@" + question.getScreenName() + " fannntooomiiinuuus #pokecenter"
						+ "   " + dateFormat.format(question.getDate()) + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(tweetPCenterPB.length() <= maxCarac) 
					return tweetPCenterPB;
				return tweetPCenter;
			}	
		}
		return null;
    }

}
