package characters;

import java.util.ArrayList;
import java.util.HashMap;

import combat.Combat;
<<<<<<< HEAD:src/characters/Personnage.java
import  java.util.ArrayList;
import java.util.HashMap;

public class Personnage implements Combat{
	
	//mes variables
	protected String name;
=======
import nonActiveClasses.AttackTypes;

public class Personnage implements Combat{
	
	protected String name;
	
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
	protected int maxLifePoints = 100;
	protected int lifePoints = 100;
	protected int maxWillPoints = 100;
	protected int willPoints = 100;
	protected int attack = 10;
	protected int magic = 5;
	protected int defence = 5;
	protected int resistance = 5;
	protected int speed = 5;
	
	protected int level = 0;
	protected int xp = 0;
	protected Class charClass;
<<<<<<< HEAD:src/characters/Personnage.java
=======
	protected AttackTypes attackType = AttackTypes.PHYSICAL;
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
	
	protected ArrayList<String[]> attacks;
	protected ArrayList<String[]> criticalHit;
	protected ArrayList<String[]> magicAttack;
	protected ArrayList<String[]> magicCriticalHit;
	
	
<<<<<<< HEAD:src/characters/Personnage.java
	//constructeur 
	public Personnage(String name, int level, int xp, String classe, ArrayList<String[]>attacks, ArrayList<String[]>criticalHit, ArrayList<String[]>magicAttack, ArrayList<String[]>magicCriticalHit) {
=======
	public Personnage(String name, int level, int xp, String classe, ArrayList<String[]> attacks,
			ArrayList<String[]> criticalHit, ArrayList<String[]> magicAttack, ArrayList<String[]> magicCriticalHit) {
		this.attacks = attacks;
		this.criticalHit = criticalHit;
		this.magicAttack = magicAttack;
		this.magicCriticalHit = magicCriticalHit;
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
		this.name = name;
		this.xp = xp;
		this.charClass = new Class(this,classe);
<<<<<<< HEAD:src/characters/Personnage.java
		this.criticalHit=criticalHit;
		this.magicAttack=magicAttack;
		this.attacks= attacks;
		this.magicCriticalHit=magicCriticalHit;
		while(this.level < level) {
			levelUp();
			this.level++;
		}
		
		}

protected void levelUp() {
	
}
=======
		while (this.level < level) {
			levelUp();
			this.level++;
		}
	}
	
	
	
	public HashMap attaquer(Personnage p) {
		HashMap toReturn = new HashMap();
		if (Math.random() > 0.9) {
			if(attackType == AttackTypes.PSYCHOLOGICAL) {
				p.setWillPoints(p.getWillPoints() - (getAttack()*2));
				toReturn.put("text", criticalHit.get((int)(Math.random()*criticalHit.size())));
				toReturn.put("damage", getAttack()*2);
			} else {
				p.setLifePoints(p.getLifePoints() - (getAttack()*2 - p.getDefence()));
				toReturn.put("text", criticalHit.get((int)(Math.random()*criticalHit.size())));
				toReturn.put("damage", getAttack()*2 - p.getDefence());
			}
		} else {
			if(attackType == AttackTypes.PSYCHOLOGICAL) {
				p.setWillPoints(p.getWillPoints() - getAttack());
				toReturn.put("text", attacks.get((int)(Math.random()*attacks.size())));
				toReturn.put("damage", getAttack());
			} else {
				p.setLifePoints(p.getLifePoints() - (getAttack() - p.getDefence()));
				toReturn.put("text", attacks.get((int)(Math.random()*attacks.size())));
				toReturn.put("damage", getAttack() - p.getDefence());
			}
		}
		return toReturn;
	}
	
	public HashMap utiliserPouvoir(Personnage p) {
		HashMap toReturn = new HashMap();
		if (Math.random() > 0.9) {
			p.setLifePoints(p.getLifePoints() - (getMagic()*2 - p.getResistance()));
			toReturn.put("text", magicCriticalHit.get((int)(Math.random()*magicCriticalHit.size())));
			toReturn.put("damage", getMagic()*2 - p.getResistance());
		} else {
			p.setLifePoints(p.getLifePoints() - (getMagic() - p.getResistance()));
			toReturn.put("text", magicAttack.get((int)(Math.random()*magicAttack.size())));
			toReturn.put("damage", getMagic() - p.getResistance());
		}
		return toReturn;
	}
	
	protected void levelUp() {
		
	}
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
	
	
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	
	public void setMaxLifePoints(int maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}
	public int getMaxWillPoints() {
		return maxWillPoints;
	}
	public void setMaxWillPoints(int maxWillPoints) {
		this.maxWillPoints = maxWillPoints;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public int getWillPoints() {
		return willPoints;
	}
	public void setWillPoints(int willPoints) {
		this.willPoints = willPoints;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public int getSpeed() {
		if (speed > 15) {
			return 15;
		} else if (speed < 0) {
			return 0;
		} else {
			return speed;
		}
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
<<<<<<< HEAD:src/characters/Personnage.java

public boolean isAlive() {
	if(lifePoints >0 && willPoints >0) {
		return true;
	}else {
		return false;
	}
}

	@Override
	public int attaquer(Personnage personnageCible) {
	
		return 0;
=======
	public boolean isAlive() {
		if (lifePoints > 0 && willPoints > 0) {
			return true;
		} else {
			return false;
		}
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
	}
	public Class getCharClass() {
		return charClass;
	}
<<<<<<< HEAD:src/characters/Personnage.java





	@Override
	public int utiliserObjet(Personnage personnageCible) {
		// TODO Auto-generated method stub
		return 0;
=======
	public void setCharClass(Class charClass) {
		this.charClass = charClass;
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
	}
	public AttackTypes getAttackType() {
		return attackType;
	}
	public void setAttackType(AttackTypes attackType) {
		this.attackType = attackType;
	}
	public ArrayList<String[]> getAttacks() {
		return attacks;
	}
	public void setAttacks(ArrayList<String[]> attacks) {
		this.attacks = attacks;
	}
	public ArrayList<String[]> getCriticalHit() {
		return criticalHit;
	}
	public void setCriticalHit(ArrayList<String[]> criticalHit) {
		this.criticalHit = criticalHit;
	}
	public ArrayList<String[]> getMagicAttack() {
		return magicAttack;
	}
	public void setMagicAttack(ArrayList<String[]> magicAttack) {
		this.magicAttack = magicAttack;
	}
	public ArrayList<String[]> getMagicCriticalHit() {
		return magicCriticalHit;
	}
	public void setMagicCriticalHit(ArrayList<String[]> magicCriticalHit) {
		this.magicCriticalHit = magicCriticalHit;
	}


<<<<<<< HEAD:src/characters/Personnage.java
	@Override
	public int utiliserPouvoir(Personnage personnageCible) {
		// TODO Auto-generated method stub
		return 0;
	}
=======






	
>>>>>>> cfe2fceeda41d5ae307267ba2ebef7e274c9696f:characters/Personnage.java
	
	
}