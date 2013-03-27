package fr.univaix.iut.pokebattle.bot;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import pokebattle.json.DataObjectPokemon;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "@pikachuNyanNian #attack #grumpycat @bulbizare1 /cc @pcreux @viviane";
		String morceau = text.split("#attack ")[1];
		System.out.println(morceau);
		String attack = morceau.split(" ")[0];
		System.out.println(attack);
		String une_attaque = attack.split("#")[1];
		System.out.println(une_attaque);
				
		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(Test.class.getClassLoader().getResourceAsStream("pokedex.json")));
		//convert the json string back to object
		DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);

		System.out.println(Arrays.toString(obj));
		
		
	}

}
