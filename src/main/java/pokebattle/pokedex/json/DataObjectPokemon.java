package pokebattle.pokedex.json;

import java.util.Arrays;

public class DataObjectPokemon {
	
	String nom;
	String espece;
	float taille;
	float poids;
	float fmratio;
    String effortval;
    String type1;
    String type2;
    int expval;
    int expmax;
    int captureval;
    String capspe1;
    String capspe2;
    String couleur;
    int forme;

    public DataObjectAttack[] attaques;
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public float getFmratio() {
		return fmratio;
	}

	public void setFmratio(float fmratio) {
		this.fmratio = fmratio;
	}

	public String getEffortval() {
		return effortval;
	}

	public void setEffortval(String effortval) {
		this.effortval = effortval;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getExpval() {
		return expval;
	}

	public void setExpval(int expval) {
		this.expval = expval;
	}

	public int getExpmax() {
		return expmax;
	}

	public void setExpmax(int expmax) {
		this.expmax = expmax;
	}

	public int getCaptureval() {
		return captureval;
	}

	public void setCaptureval(int captureval) {
		this.captureval = captureval;
	}

	public String getCapspe1() {
		return capspe1;
	}

	public void setCapspe1(String capspe1) {
		this.capspe1 = capspe1;
	}

	public String getCapspe2() {
		return capspe2;
	}

	public void setCapspe2(String capspe2) {
		this.capspe2 = capspe2;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getForme() {
		return forme;
	}

	public void setForme(int forme) {
		this.forme = forme;
	}

	public DataObjectAttack[] getAttaques() {
		return attaques;
	}

	public void setAttaques(DataObjectAttack[] attaques) {
		this.attaques = attaques;
	}

    public DataObjectPokemon(){
    }

    public DataObjectPokemon(String nom, String espece, float taille, float poids, 
                             float fmratio, String effortval,
                             String type1, String type2, int expval, int expmax, 
                             int captureval, String capspe1,
                             String capspe2, String couleur, int forme, 
                             DataObjectAttack[] attaques) {
        this.nom = nom;
        this.espece = espece;
        this.taille = taille;
        this.poids = poids;
        this.fmratio = fmratio;
        this.effortval = effortval;
        this.type1 = type1;
        this.type2 = type2;
        this.expval = expval;
        this.expmax = expmax;
        this.captureval = captureval;
        this.capspe1 = capspe1;
        this.capspe2 = capspe2;
        this.couleur = couleur;
        this.forme = forme;
        this.attaques = attaques;
    }

    @Override
    public String toString() {
        return "DataObjectPokemon{" +
                "nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", taille=" + taille +
                ", poids=" + poids +
                ", fmratio=" + fmratio +
                ", effortval='" + effortval + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", expval=" + expval +
                ", expmax=" + expmax +
                ", captureval=" + captureval +
                ", capspe1='" + capspe1 + '\'' +
                ", capspe2='" + capspe2 + '\'' +
                ", couleur='" + couleur + '\'' +
                ", forme=" + forme +
                ", attaques=" + (attaques == null ? null : Arrays.asList(attaques)) +
                '}';
    }
}