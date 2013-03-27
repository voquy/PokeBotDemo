package fr.univaix.iut.pokebattle.run;

import BD.java.fr.univaix.iut.progbd.Main;
import fr.univaix.iut.pokebattle.bot.DresseurBot;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {

    public static void main(String[] args) {
        BotRunner.runBot(new PokeBot(), "PkmFantominus.properties");
        BotRunner.runBot(new JudgeBot(), "JugeCordier.properties");
        BotRunner.runBot(new DresseurBot(), "DrsPierre.properties");
        Main.Creer();
        PokeBot.owner=null;
    }
}
