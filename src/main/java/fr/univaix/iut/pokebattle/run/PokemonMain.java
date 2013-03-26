package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.DresseurBot;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {

    public static void main(String[] args) {
        BotRunner.runBot(new PokeBot(), "PkmFantominus.properties");
        BotRunner.runBot(new JudgeBot(), "JugeCordier.properties");
        BotRunner.runBot(new DresseurBot(), "DrsPierre.properties");
    }
}
