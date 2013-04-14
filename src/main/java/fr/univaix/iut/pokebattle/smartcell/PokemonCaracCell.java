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
				String stats = question.getText().toLowerCase().split(" ")[2];
				
				if (stats.contains("#level"))
				{
					//Tweet level sans #PokeBattle
					String tweetLvl = "@" + emetteur +" "+ stats + "=" + PokeBot.getLevel();
					
					//Tweet level avec #PokeBattle
					String tweetLvlPB = "@" + emetteur +" "+ stats + "=" + PokeBot.getLevel() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(tweetLvlPB.length() <= maxCarac) {
						return tweetLvlPB;
					}
					return tweetLvl;
				}	
				else if (stats.contains("#xp"))
				{
					//Tweet xp sans #PokeBattle
					String TweetXP = "@" + emetteur +" "+ stats + "=" + PokeBot.getExp();
					
					//Tweet xp avec #PokeBattle
					String TweetXPPB = "@" + emetteur +" "+ stats + "=" + PokeBot.getExp()  + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetXPPB.length() <= maxCarac) {
						return TweetXPPB;
					}
					return TweetXP;
				}
				else if (stats.contains("#pv"))
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
					String tweetPv = "@" + emetteur +" " + stats + "=" + PokeBot.getPvRestant()
							+ "/" + PokeBot.getPvTotal();
					
					//Tweet pv avec #PokeBattle
					String tweetPvPB = "@" + emetteur +" " + stats + "=" + PokeBot.getPvRestant()
							+ "/" + PokeBot.getPvTotal() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(tweetPvPB.length() <= maxCarac) {
						return tweetPvPB;
					}
					return tweetPv;	
				}
				else if (stats.contains("#pp"))
				{
					String attaque = question.getText().toLowerCase().split(" ")[3];			
					
					//Tweet pv sans #PokeBattle
					String tweetPp = "@" + emetteur + " " + attaque + " " + stats
							+ "=" + PokeBot.getPpRestant() + "/" + PokeBot.getPpTotal();
					
					//Tweet pv avec #PokeBattle
					String tweetPpPB = "@" + emetteur + " " + attaque + " " + stats
							+ "=" + PokeBot.getPpRestant() + "/" + PokeBot.getPpTotal() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(tweetPpPB.length() <= maxCarac) {
						return tweetPpPB;
					}
					return tweetPp;	
				}
					
			}
			return null;
		}
		return null;
    }

}
