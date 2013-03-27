package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.DresseurBot;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {

    public static void main(String[] args) {
    	System.out.println("test1");
        BotRunner.runBot(new PokeBot(), "PkmFantominus.properties");
        System.out.println("test2");
        BotRunner.runBot(new JudgeBot(), "JugeCordier.properties");
        System.out.println("test3");
        BotRunner.runBot(new DresseurBot(), "DrsPierre.properties");
    }
}
