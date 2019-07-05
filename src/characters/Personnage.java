package characters;

import combat.Combat;
import  java.util.ArrayList;
import java.util.HashMap;

public class Personnage implements Combat{
	
	//mes variables
	protected String name;
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
	
	protected ArrayList<String[]> attacks;
	protected ArrayList<String[]> criticalHit;
	protected ArrayList<String[]> magicAttack;
	protected ArrayList<String[]> magicCriticalHit;
	
	
	//constructeur 
	public Personnage(String name, int level, int xp, String classe, ArrayList<String[]>attacks, ArrayList<String[]>criticalHit, ArrayList<String[]>magicAttack, ArrayList<String[]>magicCriticalHit) {
		this.name = name;
		this.level = level;
		this.xp = xp;
		this.charClass = new Class(this,classe);
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
		return speed;
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
	}









	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public int utiliserObjet(Personnage personnageCible) {
		// TODO Auto-generated method stub
		return 0;
	}









	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int utiliserPouvoir(Personnage personnageCible) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}