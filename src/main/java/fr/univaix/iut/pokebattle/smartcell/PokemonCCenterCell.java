package fr.univaix.iut.pokebattle.smartcell;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCCenterCell implements SmartCell{
	static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
	
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (emetteur.toLowerCase().equals("joellebpalette"))
		{
			if (question.getText().toLowerCase().contains("#pokecenter"))
			{
				return "@" + question.getScreenName() + " fannntooomiiinuuus #pokecenter"
						+ "   " + dateFormat.format(question.getDate());
			}	
		}
		return null;
    }

}
