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
					String TweetL = "@" + emetteur +" "+ Stat + "=" + PokeBot.getLevel();
					
					//Tweet level avec #PokeBattle
					String TweetLPB = "@" + emetteur +" "+ Stat + "=" + PokeBot.getLevel() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetLPB.length() <= maxCarac) 
						return TweetLPB;
					return TweetL;
				}	
				else if (Stat.contains("#xp"))
				{
					//Tweet xp sans #PokeBattle
					String TweetXP = "@" + emetteur +" "+ Stat + "=" + PokeBot.getExp();
					
					//Tweet xp avec #PokeBattle
					String TweetXPPB = "@" + emetteur +" "+ Stat + "=" + PokeBot.getExp()  + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetXPPB.length() <= maxCarac) 
						return TweetXPPB;
					return TweetXP;
				}
				else if (Stat.contains("#pv"))
				{
					long temps = PokemonTempsInactif.run(PokeBot.getLastAttack());
					int nbFoisVie = 0;
					// Si temps d'inactivité supérieur/égal à au moins 1h
					if (temps >= 3600 && (PokeBot.getPvRestant() < PokeBot.getPvTotal()))
					{
						nbFoisVie = (int) ((temps)/3600);
						PokeBot.setPvRestant(PokeBot.getPvRestantLast() + ((PokeBot.getPvTotal()/10) * nbFoisVie));
						if (PokeBot.getPvRestant() >= PokeBot.getPvTotal())
						{
							PokeBot.setPvRestant(PokeBot.getPvTotal());
							PokeBot.setPvRestantLast(PokeBot.getPvTotal());
						}
					}
					
					//Tweet pv sans #PokeBattle
					String TweetPV = "@" + emetteur +" " + Stat + "=" + PokeBot.getPvRestant()
							+ "/" + PokeBot.getPvTotal();
					
					//Tweet pv avec #PokeBattle
					String TweetPVPB = "@" + emetteur +" " + Stat + "=" + PokeBot.getPvRestant()
							+ "/" + PokeBot.getPvTotal() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetPVPB.length() <= maxCarac) 
						return TweetPVPB;
					return TweetPV;	
				}
				else if (Stat.contains("#pp"))
				{
					String Attaque = question.getText().toLowerCase().split(" ")[3];			
					
					//Tweet pv sans #PokeBattle
					String TweetPP = "@" + emetteur + " " + Attaque + " " + Stat
							+ "=" + PokeBot.getPpRestant() + "/" + PokeBot.getPpTotal();
					
					//Tweet pv avec #PokeBattle
					String TweetPPPB = "@" + emetteur + " " + Attaque + " " + Stat
							+ "=" + PokeBot.getPpRestant() + "/" + PokeBot.getPpTotal() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetPPPB.length() <= maxCarac) 
						return TweetPPPB;
					return TweetPP;	
				}
					
			}
			return null;
		}
		return null;
    }

}
