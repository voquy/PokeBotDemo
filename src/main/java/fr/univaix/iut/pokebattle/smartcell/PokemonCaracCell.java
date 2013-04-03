package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BD.java.fr.univaix.iut.progbd.DAOPokemonJPA;
import BD.java.fr.univaix.iut.progbd.Pokemon;
import pokebattle.functions.PokemonTempsInactif;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCell implements SmartCell{

	public String ask(Tweet question) {
		
		String emetteur = question.getScreenName().toLowerCase();
		
		System.out.println("Tweet émis : " + question.getText());
		System.out.println("Emetteur : " + emetteur);
		
		if (emetteur.toLowerCase().equals("quynhchee")
			|| emetteur.toLowerCase().equals("jeremsboot") || emetteur.toLowerCase().equals("dounouw")
			|| emetteur.toLowerCase().equals("graiig1") || emetteur.toLowerCase().equals("brownrock_")
			|| emetteur.toLowerCase().equals("joellebpalette") )
		{
	
			if (question.getText().toLowerCase().contains("#stat"))
			{
				String Stat = question.getText().toLowerCase().split(" ")[2];
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
			    EntityManager em = emf.createEntityManager();
			    
			    DAOPokemonJPA dao = new DAOPokemonJPA(em);
			    Pokemon Fantomiinus = dao.getById("Fantomiinus");
				if (Stat.contains("#level"))
					return "@" + emetteur +" "+ Stat + "=" + Fantomiinus.getLevel();
				else if (Stat.contains("#xp"))
					return "@" + emetteur +" "+ Stat + "=" + Fantomiinus.getExp();
				else if (Stat.contains("#pv"))
				{
					/*long temps = PokemonTempsInactif.run(Fantomiinus.getLastAttack());
					int nbFoisVie = 0;
					// Si temps d'inactivité supérieur/égal à au moins 1h
					if (temps >= 3600 && (PokeBot.getPVRestant() < PokeBot.getPVTotal()))
					{
						nbFoisVie = (int) ((temps)/3600);
						
					    int PvTotal = Fantomiinus.getHPTotal();
					    Fantomiinus.setBaseHP(PokeBot.getPVRestantLast() + ((PvTotal/10) * nbFoisVie));
						//PokeBot.setPVRestant(PokeBot.getPVRestantLast() + ((PokeBot.getPVTotal()/10) * nbFoisVie));
						if (Fantomiinus.getBaseHP() >= Fantomiinus.getHPTotal())
						{
							Fantomiinus.setBaseHP(Fantomiinus.getHPTotal());
							PokeBot.setPVRestantLast(Fantomiinus.getHPTotal());
						}
						boolean update = dao.update(Fantomiinus);
					}*/
					long temps = PokemonTempsInactif.run(Fantomiinus.getLastAttack());
					int nbFoisVie = 0;
					System.out.println(temps);
					System.out.println(Fantomiinus.getLastAttack());
					// Si temps d'inactivité supérieur/égal à au moins 1h
					if (temps >= 3600 && (Fantomiinus.getBaseHP() < Fantomiinus.getHPTotal()))
					{
						nbFoisVie = (int) ((temps)/3600);
						
					    int PvTotal = Fantomiinus.getHPTotal();
					    Fantomiinus.setBaseHP(Fantomiinus.getBaseHP() + ((PvTotal/10) * nbFoisVie));
						//PokeBot.setPVRestant(PokeBot.getPVRestantLast() + ((PokeBot.getPVTotal()/10) * nbFoisVie));
						if (Fantomiinus.getBaseHP() >= Fantomiinus.getHPTotal())
						{
							Fantomiinus.setBaseHP(Fantomiinus.getHPTotal());
							PokeBot.setPVRestantLast(Fantomiinus.getHPTotal());
						}
						boolean update = dao.update(Fantomiinus);
					}
					/*long temps = PokemonTempsInactif.run(Fantomiinus.getLastAttack());
					Fantomiinus.setBaseHP(Fantomiinus.getBaseHP()+10);
					boolean update = dao.update(Fantomiinus);*/
					em.close();
					emf.close();
					return "@" + emetteur +" " + Stat + "=" + Fantomiinus.getBaseHP() + "/" + Fantomiinus.getHPTotal();
				}
				else if (Stat.contains("#pp"))
				{
					String Attaque = question.getText().toLowerCase().split(" ")[3];
					return "@" + emetteur + " " + Attaque + " " + Stat + "=" + PokeBot.ppRestant + "/" + PokeBot.ppTotal;		
				}
					
			}	
		}
		return null;
    }

}
