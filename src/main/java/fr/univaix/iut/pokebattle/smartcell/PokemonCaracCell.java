package fr.univaix.iut.pokebattle.smartcell;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import pokebattle.functions.PokemonTempsInactif;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCell implements SmartCell{
	static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
	static final int maxCarac = 140;
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		if (emetteur.equals("quynhchee")
			|| emetteur.equals("jeremsboot") || emetteur.equals("dounouw")
			|| emetteur.equals("graiig1") || emetteur.equals("brownrock_")
			|| emetteur.equals("joellebpalette") )
		{
	
			if (question.getText().toLowerCase().contains("#stat"))
			{
				String Stat = question.getText().toLowerCase().split(" ")[2];
				
				if (Stat.contains("#level"))
				{
					//Tweet level sans #PokeBattle
					String TweetL = "@" + emetteur +" "+ Stat + "=" + PokeBot.level;
					
					//Tweet level avec #PokeBattle
					String TweetLPB = "@" + emetteur +" "+ Stat + "=" + PokeBot.level + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetLPB.length() <= maxCarac) 
						return TweetLPB;
					else
						return TweetL;
				}	
				else if (Stat.contains("#xp"))
				{
					//Tweet xp sans #PokeBattle
					String TweetXP = "@" + emetteur +" "+ Stat + "=" + PokeBot.exp;
					
					//Tweet xp avec #PokeBattle
					String TweetXPPB = "@" + emetteur +" "+ Stat + "=" + PokeBot.exp + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetXPPB.length() <= maxCarac) 
						return TweetXPPB;
					else
						return TweetXP;
				}
				else if (Stat.contains("#pv"))
				{
					long temps = PokemonTempsInactif.run(PokeBot.lastAttack);
					int nbFoisVie = 0;
					// Si temps d'inactivité supérieur/égal à au moins 1h
					if (temps >= 3600 && (PokeBot.getPVRestant() < PokeBot.getPVTotal()))
					{
						nbFoisVie = (int) ((temps)/3600);
						PokeBot.setPVRestant(PokeBot.getPVRestantLast() + ((PokeBot.getPVTotal()/10) * nbFoisVie));
						if (PokeBot.getPVRestant() >= PokeBot.getPVTotal())
						{
							PokeBot.setPVRestant(PokeBot.getPVTotal());
							PokeBot.setPVRestantLast(PokeBot.getPVTotal());
						}
					}
					
					//Tweet pv sans #PokeBattle
					String TweetPV = "@" + emetteur +" " + Stat + "=" + PokeBot.pvRestant
							+ "/" + PokeBot.pvTotal;
					
					//Tweet pv avec #PokeBattle
					String TweetPVPB = "@" + emetteur +" " + Stat + "=" + PokeBot.pvRestant
							+ "/" + PokeBot.pvTotal + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetPVPB.length() <= maxCarac) 
						return TweetPVPB;
					else
						return TweetPV;	
				}
				else if (Stat.contains("#pp"))
				{
					String Attaque = question.getText().toLowerCase().split(" ")[3];			
					
					//Tweet pv sans #PokeBattle
					String TweetPP = "@" + emetteur + " " + Attaque + " " + Stat
							+ "=" + PokeBot.ppRestant + "/" + PokeBot.ppTotal;
					
					//Tweet pv avec #PokeBattle
					String TweetPPPB = "@" + emetteur + " " + Attaque + " " + Stat
							+ "=" + PokeBot.ppRestant + "/" + PokeBot.ppTotal + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetPPPB.length() <= maxCarac) 
						return TweetPPPB;
					else
						return TweetPP;	
				}
					
			}
			return null;
		}
		return null;
    }

}
