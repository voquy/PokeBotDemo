package fr.univaix.iut.pokebattle.smartcell;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeMonTestCell implements SmartCell{
	static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
	
	public String ask(Tweet question) {

		if (question.getText().toLowerCase().contains("plusieurs")) {
			return "Je te tweet" + dateFormat.format(question.getDate())
				+ ";;Je te retweet" + dateFormat.format(question.getDate());
		}
		
		return null;
    }
	

}
