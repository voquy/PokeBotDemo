package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCell implements SmartCell{

	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		int Level = 1;
		int XP = 0;
		int PVRestant = 10;
		int PVTotal = 100;
		int PPRestant = 10;
		int PPTotal = 35;
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		String Stat = question.getText().toLowerCase().split(" ")[2];
		
		if (emetteur.toLowerCase().equals("quynhchee")
			|| emetteur.toLowerCase().equals("jeremsboot") || emetteur.toLowerCase().equals("dounouw")
			|| emetteur.toLowerCase().equals("graiig1") || emetteur.toLowerCase().equals("brownrock_"))
		{
	
			if (question.getText().toLowerCase().contains("#stat"))
			{
				if (Stat.contains("#level"))
					return "@" + emetteur +" "+ Stat + "=" + Level;
				else if (Stat.contains("#xp"))
					return "@" + emetteur +" "+ Stat + "=" + XP;
				else if (Stat.contains("#pv"))
					return "@" + emetteur +" " + Stat + "=" + PVRestant + "/" + PVTotal;
				else if (Stat.contains("#pp"))
				{
					String Attaque = question.getText().toLowerCase().split(" ")[3];
					return "@" + emetteur + " " + Attaque + " " + Stat + "=" + PPRestant + "/" + PPTotal;		
				}
					
			}	
		}
		return null;
    }

}
