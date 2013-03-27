package pokebattle.functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import pokebattle.pokedex.json.DataObjectAttack;
import pokebattle.pokedex.json.DataObjectPokemon;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.bot.Test;

public class PokemonAttackValide {
	static DataObjectAttack[] attaques;
	
	public static DataObjectAttack[] recupererDonneesPokedex (String nomPkm) {
		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(Test.class.getClassLoader().getResourceAsStream("pokedex.json")));
		//convert the json string back to object
		DataObjectPokemon[] objs = gson.fromJson(br, DataObjectPokemon[].class);
		
		for (int i = 0 ; i<objs.length ; i++)
		{
			if (objs[i].getNom().toLowerCase().equals(nomPkm.toLowerCase()))
			{
				System.out.println(objs[0].getEspece());
				for (int j = 0 ; j<objs[0].attaques.length ; j++)
				{
					attaques = objs[i].getAttaques();
					// System.out.println(attaques[1].getNom());
				}
				return attaques;
			}
		}
		return null;
	}
	
	
	public static boolean goodLevel (DataObjectAttack[] tabAttack, String monAttack, int lvl) {
		for (int i = 0 ; i < tabAttack.length ; i++)
		{
			if (monAttack.toLowerCase().equals(tabAttack[i].getNom().toLowerCase()))
			{
				String recupLvl1 = tabAttack[i].getNiveau();
				if (recupLvl1.equals("Départ")) return true;
				
				String recupLvl = recupLvl1.split(".")[1];
				
				int lvlAttack = Integer.decode(recupLvl);
				
				if (lvl >= lvlAttack)
					return true;
				return false;
			}
		}
		return false;
	}
	
	
	public static boolean run (String pkmFind, String pkmFindAttack, int pkmLvl) {
		attaques = recupererDonneesPokedex(pkmFind);
		if (attaques == null) return false;
		
		return goodLevel(attaques, pkmFindAttack, pkmLvl);
	}
	
	
	
	public static void main(String[] args) {
		boolean result = run("carapuce", "charge", 5);
		
		if (result == true) {
			System.out.println("Ok");
		}
		else {
			System.out.println("Attaque non adéquat");
		}
	}

}
