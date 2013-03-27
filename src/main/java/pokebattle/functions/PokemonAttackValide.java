package pokebattle.functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import pokebattle.pokedex.json.DataObjectAttack;
import pokebattle.pokedex.json.DataObjectPokemon;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.bot.Test;

public class PokemonAttackValide {
	DataObjectAttack[] attaques;
	
	public DataObjectAttack[] recupererDonneesPokedex (String nomPkm) {
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
				int z = 0;
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
	
	
	public boolean goodLevel (DataObjectAttack[] tabAttack, String monAttack, int lvl) {
		for (int i = 0 ; i < tabAttack.length ; i++)
		{
			if (monAttack.toLowerCase().equals(tabAttack[i].getNom().toLowerCase()))
			{
				String recupLvl = tabAttack[i].getNom().split(".")[1];
				int lvlAttack = Integer.decode(recupLvl);
				if (lvl >= lvlAttack)
					return true;
				return false;
			}
		}
		return false;
	}
	
	
	public boolean run (String pkmFind) {
		attaques = recupererDonneesPokedex(pkmFind);
		return goodLevel(attaques, monAttack, lvl)
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
