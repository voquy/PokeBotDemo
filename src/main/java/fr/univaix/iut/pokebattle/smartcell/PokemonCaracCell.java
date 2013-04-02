package fr.univaix.iut.pokebattle.smartcell;

import pokebattle.functions.PokemonTempsInactif;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCell implements SmartCell{

	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (emetteur.toLowerCase().equals("quynhchee")
			|| emetteur.toLowerCase().equals("jeremsboot") || emetteur.toLowerCase().equals("dounouw")
			|| emetteur.toLowerCase().equals("graiig1") || emetteur.toLowerCase().equals("brownrock_")
			|| emetteur.toLowerCase().equals("joellebpalette") )
		{
	
			if (question.getText().toLowerCase().contains("#stat"))
			{
				String Stat = question.getText().toLowerCase().split(" ")[2];
				
				if (Stat.contains("#level"))
					return "@" + emetteur +" "+ Stat + "=" + PokeBot.level;
				else if (Stat.contains("#xp"))
					return "@" + emetteur +" "+ Stat + "=" + PokeBot.exp;
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
					return "@" + emetteur +" " + Stat + "=" + PokeBot.pvRestant + "/" + PokeBot.pvTotal;
				}
				else if (Stat.contains("#pp"))
				{
					String Attaque = question.getText().toLowerCase().split(" ")[3];
					return "@" + emetteur + " " + Attaque + " " + Stat + "=" + PokeBot.ppRestant + "/" + PokeBot.ppTotal;		
				}
					
			}
			return null;
		}
		return null;
    }

}
