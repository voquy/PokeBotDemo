package fr.univaix.iut.pokebattle.bot;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.run.BotRunner;


public class Test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//BotRunner.runBot(new PokeBot(), "PkmFantominus.properties");
		
		// Suspendu pendant 60 sec
		/*
		Thread.sleep(60000);
		
		Date dateNow = new Date();
		String sFormat = "dd/MM/yyyy HH:mm";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");;
		//String test = sdf2.format(myDate) + " " +  myTime.replace('H', ':');
		// Date myDateTotale= sdf.parse(test); //marche pas!!

		long diff = dateNow.getTime() - PokeBot.lastAttack.getTime();
		
		System.out.println(diff / 1000);
		System.out.println(sdf1.format(PokeBot.getLastAttack()));
		System.out.println(PokeBot.getLastAttack().getTime());
		System.out.println(sdf1.format(dateNow));
		System.out.println(dateNow.getTime());
		*/
		
		long nombre = 1212;
		int un = (int) (nombre / 10);
		System.out.println(un);
	}

}
