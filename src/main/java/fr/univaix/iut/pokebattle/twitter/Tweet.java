package fr.univaix.iut.pokebattle.twitter;

import java.util.Date;



public class Tweet {
    private String text;
    private String screenName;
    private Date date = new Date();

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(String screenName, String text, Date date) {
        this.screenName = screenName;
        this.text = text;
        this.setDate(date);
    }

    public String getScreenName() {
        return screenName;
    }

    public String getText() {
        return text;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    
}
