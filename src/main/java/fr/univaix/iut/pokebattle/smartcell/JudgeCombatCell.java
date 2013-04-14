package fr.univaix.iut.pokebattle.smartcell;


import pokebattle.functions.JudgeCalculExpWin;
import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeCombatCell implements SmartCell{
	static final int maxCarac = 140;
	
	public String ask(Tweet question) {
		
		String emetteur = "@" +  question.getScreenName().toLowerCase();
		String emet = question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (question.getText().toLowerCase().contains("#ko")) {
			// Penser à ajouter l'exp gagné au pokémon vainqueur, faire un set
			if(emetteur.toLowerCase().equals(JudgeBot.getPokemonDress1().toLowerCase()))
			{
																// PkmGagnant					PkmPerdant
				int expWin = JudgeCalculExpWin.calculExp(JudgeBot.getPokemonDress2(), JudgeBot.getPokemonDress1());
				
				//Tweet calcul exp1 sans #PokeBattle
				String TweetCE1 = JudgeBot.getPokemonDress2() + " #Win +" + expWin + "xp";
				
				//Tweet calcul exp1 avec #PokeBattle
				String TweetCE1PB = JudgeBot.getPokemonDress2() + " #Win +" + expWin + "xp" + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(TweetCE1PB.length() <= maxCarac) 
					return TweetCE1PB;
				else
					return TweetCE1;			
			}
																//	PkmGagnant					PkmPerdant
			int expWin = JudgeCalculExpWin.calculExp(JudgeBot.getPokemonDress1(), JudgeBot.getPokemonDress2());
			
			//Tweet calcul exp2 sans #PokeBattle
			String TweetCE2 = JudgeBot.getPokemonDress1() + " #Win +" + expWin + "xp";
			
			//Tweet calcul exp2 avec #PokeBattle
			String TweetCE2PB = JudgeBot.getPokemonDress1() + " #Win +" + expWin + "xp" + " #PokeBattle"; 
			
			//Si le tweet fait moins de 140 caractères
			if(TweetCE2PB.length() <= maxCarac) 
				return TweetCE2PB;
			else
				return TweetCE2;
		}
		
		if (emet.equals("fantomiinus") || emet.equals("pikachu")
				|| emet.equals("pikachuNyanNian")) {
		
			if (question.getText().contains("#attack"))
			{
				String pokemonAttaqué = question.getText().split(" ")[0];
				String dresseur = question.getText().split("/cc")[1];
				String dresseursubit = dresseur.split(" ")[1];	
				/*
				//Tweet perte pv sans #PokeBattle
				String TweetPPV = pokemonAttaqué + " -10pv /cc " + dresseursubit;
				
				//Tweet perte pv avec #PokeBattle
				String TweetPPVPB = pokemonAttaqué + " -10pv /cc " + dresseursubit + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(TweetPPVPB.length() <= maxCarac) 
					return TweetPPVPB;
				else
					return TweetPPV;
					*/

				if (pokemonAttaqué.equals(JudgeBot.getPokemonDress1())) {
					JudgeBot.setNumRound(JudgeBot.getNumRound()+1);
			
					//Tweet perte pv juge sans #PokeBattle
					String TweetPPVJ = pokemonAttaqué + " -10pv /cc " + dresseursubit + ";;"
							+ "Round #" + JudgeBot.getNumRound() + " /cc"
							+ " @" + JudgeBot.getAdversaire2() + " " + JudgeBot.getPokemonDress2()
							+ " @" + JudgeBot.getAdversaire1() + " " + JudgeBot.getPokemonDress1();
					
					//Tweet perte pv avec juge avec #PokeBattle
					String TweetPPVJPB = pokemonAttaqué + " -10pv /cc " + dresseursubit + " #PokeBattle;;"
							+ "Round #" + JudgeBot.getNumRound() + " /cc"
							+ " @" + JudgeBot.getAdversaire2() + " " + JudgeBot.getPokemonDress2()
							+ " @" + JudgeBot.getAdversaire1() + " " + JudgeBot.getPokemonDress1()
							+ " #PokeBattle"; 
					
					//Si le tweet fait moins de 140 caractères
					if(TweetPPVJPB.length() <= maxCarac) 
						return TweetPPVJPB;
					else
						return TweetPPVJ;
				}
				
				//Tweet perte pv  sans #PokeBattle
				String TweetPPV = pokemonAttaqué + " -10pv /cc " + dresseursubit;
				
				//Tweet perte pv avec juge avec #PokeBattle
				String TweetPPVPB = pokemonAttaqué + " -10pv /cc " + dresseursubit + " #PokeBattle"; 
				
				//Si le tweet fait moins de 140 caractères
				if(TweetPPVPB.length() <= maxCarac) 
					return TweetPPVPB;
				else
					return TweetPPV;
			
			}
		}
		return null;
    }
	

}
