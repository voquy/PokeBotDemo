package BD.java.fr.univaix.iut.progbd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
        @NamedQuery(name = Pokemon.FIND_ALL, query = "SELECT p FROM Pokemon p"),
        @NamedQuery(name = Pokemon.FIND_BY_TYPE, query = "SELECT p FROM Pokemon p WHERE p.type1 = :ftype")
})
public class Pokemon {
    public static final String FIND_BY_TYPE = "findPokemonByType";
    public static final String FIND_ALL = "findAllPokemon";
    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type1;

    @Enumerated(EnumType.STRING)
    private Type type2;

    private int baseHP;
    private int attack;
    private int defense;
    private int attackSpecial;
    private int defenseSpecial;
    private int speed;
    private String Owner;
    private int level;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastAttack;
    private String TrueName;
    private int HPTotal;
    @Column(precision=3,scale=5)
    private double Exp;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastImproveCondition;
    
    public Pokemon() {

    }

    public Pokemon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type types1) {
        this.type1 = types1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type types2) {
        this.type2 = types2;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttackSpecial() {
        return attackSpecial;
    }

    public void setAttackSpecial(int attackSpecial) {
        this.attackSpecial = attackSpecial;
    }

    public int getDefenseSpecial() {
        return defenseSpecial;
    }

    public void setDefenseSpecial(int defenseSpecial) {
        this.defenseSpecial = defenseSpecial;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;

        Pokemon pokemon = (Pokemon) o;

        if (attack != pokemon.attack) return false;
        if (attackSpecial != pokemon.attackSpecial) return false;
        if (baseHP != pokemon.baseHP) return false;
        if (defense != pokemon.defense) return false;
        if (defenseSpecial != pokemon.defenseSpecial) return false;
        if (speed != pokemon.speed) return false;
        if (name != null ? !name.equals(pokemon.name) : pokemon.name != null) return false;
        if (type1 != pokemon.type1) return false;
        if (type2 != pokemon.type2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type1 != null ? type1.hashCode() : 0);
        result = 31 * result + (type2 != null ? type2.hashCode() : 0);
        result = 31 * result + baseHP;
        result = 31 * result + attack;
        result = 31 * result + defense;
        result = 31 * result + attackSpecial;
        result = 31 * result + defenseSpecial;
        result = 31 * result + speed;
        result = 31 * result + level;
        return result;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", types1=" + type1 +
                ", types2=" + type2 +
                ", baseHP=" + baseHP +
                ", attack=" + attack +
                ", defense=" + defense +
                ", attackSpecial=" + attackSpecial +
                ", defenseSpecial=" + defenseSpecial +
                ", speed=" + speed +
                ", owner=" + Owner +
                ", level=" + level +
                ", LastAttack=" + LastAttack +
              
                '}';
    }

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Date getLastAttack() {
		return LastAttack;
	}

	public void setLastAttack(Date date) {
		this.LastAttack = date;
	}

	public String getTrueName() {
		return TrueName;
	}

	public void setTrueName(String trueName) {
		this.TrueName = trueName;
	}

	public int getHPTotal() {
		return HPTotal;
	}

	public void setHPTotal(int hPTotal) {
		this.HPTotal = hPTotal;
	}

	public Date getLastImproveCondition() {
		return LastImproveCondition;
	}

	public void setLastImproveCondition(Date lastImproveCondition) {
		this.LastImproveCondition = lastImproveCondition;
	}

	public double getExp() {
		return Exp;
	}

	public void setExp(double Exp) {
		this.Exp = Exp;
	}
	
}
