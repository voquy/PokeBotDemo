package fr.univaix.iut.pokebattle.smartcell;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {
	static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

    public String ask(Tweet question) {
        if (question.getScreenName() != null)
        	return ("@" + question.getScreenName() + " fannntooomiiinuuus"
        			+ " " + dateFormat.format(question.getDate()));
        return "fannntooomiiinuuus" + " " + dateFormat.format(question.getDate());
    }

}
