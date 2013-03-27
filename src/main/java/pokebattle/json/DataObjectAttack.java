package pokebattle.json;

public class DataObjectAttack {
	String niveau;
	String nom;
	String puissance;
	String precision;
	String pp;

	public DataObjectAttack(String niveau, String nom, String puissance, String precision, 
                            String pp) {
		this.niveau = niveau;
		this.nom = nom;
		this.puissance = puissance;
		this.precision = precision;
		this.pp = pp;
    }

    @Override
	public String toString() {
    	return 	"DataObjectAttack{" +
    			"niveau='" + niveau + '\'' +
    			", nom='" + nom + '\'' +
    			", puissance=" + puissance +
    			", precision=" + precision +
    			", pp=" + pp +
    			'}';
    }
}