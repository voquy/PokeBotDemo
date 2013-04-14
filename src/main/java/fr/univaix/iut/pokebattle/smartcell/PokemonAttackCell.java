package fr.univaix.iut.pokebattle.smartcell;

import pokebattle.functions.PokemonAttackValide;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonAttackCell implements SmartCell{
	static final int maxCarac = 140;
	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		if (emetteur.equals("quynhchee")
			|| emetteur.equals("jeremsboot") || emetteur.equals("dounouw")
			|| emetteur.equals("graiig1") || emetteur.equals("brownrock_"))
		{
			if (question.getText().toLowerCase().contains("#attack"))
			{
				String text = question.getText().toLowerCase().split("#attack ")[1];
				String ok = text.split("#")[1];
				String nomAttaque = ok.split(" ")[0];
				
				/*
				String dresseuradverse = question.getText().split(" ")[5];
				String juge = question.getText().split(" ")[6];
				String attaque = question.getText().split(" ")[1]
								+ " " + question.getText().split(" ")[2]
								+ " " + question.getText().split(" ")[4];
				String pokemonAttaqué = question.getText().split(" ")[3];
				String pokemonRecoitTweet = question.getText().split(" ")[0];
				*/
				String rien = question.getText().split("@")[3];
				text = "@" + rien;
				String dresseurAdverse = text.split(" ")[0];
				String juge = "@" + question.getText().split("@")[4];
				rien = question.getText().split("@")[2];
				text = "@" + rien;
				String pokemonVise = text.split(" ")[0];
				
				if (PokemonAttackValide.run(PokeBot.getVraiNom(), nomAttaque, PokeBot.getLevel()))
				{	
					
					/*				
					return pokemonAttaqué + " " + attaque + " " + dresseuradverse
							+ " @" + question.getScreenName() + " " + juge;
					*/
					
					// Sauvegarde la date-heure de la dernière attaque du pokemon
					PokeBot.setLastAttack(question.getDate());
					
					//Tweet attack Pkmn sans #PokeBattle
					String tweetAtk = pokemonVise + " #attack #" + nomAttaque + " /cc "
							+ dresseurAdverse + " " + "@" + question.getScreenName() 
							+ " " + juge + " #" + JudgeBot.getNumRound();
					
					//Tweet attack Pkmn avec #PokeBattle
					String tweetAtkPB = pokemonVise + " #attack #" + nomAttaque + " /cc "
							+ dresseurAdverse + " " + "@" + question.getScreenName()
							+ " " + juge + " #" + JudgeBot.getNumRound() + " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(tweetAtkPB.length() <= maxCarac) {
						return tweetAtkPB;
					}
					return tweetAtk;

				}
				
				//Tweet attack inconnue Pkmn sans #PokeBattle
				String tweetAtkInc = "@" + question.getScreenName() + " o_O ? /cc " + dresseurAdverse
						+ " " + juge + " " + pokemonVise;
				
				//Tweet attack inconnue Pkmn avec #PokeBattle
				String tweetAtkIncPB = "@" + question.getScreenName() + " o_O ? /cc " + dresseurAdverse
						+ " " + juge + " " + pokemonVise + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(tweetAtkIncPB.length() <= maxCarac) 
					return tweetAtkIncPB;
				return tweetAtkInc;
				
			}
		}
		return null;
    }
}
